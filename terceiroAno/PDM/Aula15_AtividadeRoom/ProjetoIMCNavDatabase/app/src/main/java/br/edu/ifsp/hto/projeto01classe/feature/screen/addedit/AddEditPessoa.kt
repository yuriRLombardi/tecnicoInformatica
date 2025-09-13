package br.edu.ifsp.hto.projeto01classe.feature.screen.addedit

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.hto.projeto01classe.data.PessoaDatabaseProvider
import br.edu.ifsp.hto.projeto01classe.data.PessoaRepositoryImpl
import br.edu.ifsp.hto.projeto01classe.domain.Pessoa
import br.edu.ifsp.hto.projeto01classe.domain.pessoa
import br.edu.ifsp.hto.projeto01classe.feature.screen.list.ListEvent
import kotlinx.coroutines.launch


@SuppressLint("DefaultLocale")
@Composable
fun AddEditPessoa(
    pessoaID: Long?,
    onBack: () -> Unit
) {
    var nome by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var imc by remember { mutableStateOf("") }
    var textoBotao by remember { mutableStateOf("Adicionar") }

    val context = LocalContext.current.applicationContext

    val database = PessoaDatabaseProvider.provide(context)

    val pessoaRepository = PessoaRepositoryImpl(database.pessoaDAO())

    LaunchedEffect(Unit) {

        val pessoaFromDB = pessoaID?.let { pessoaRepository.getPessoaById(it) }
        if (pessoaFromDB != null) {
            nome = pessoaFromDB.nome
            peso = pessoaFromDB.peso.toString()
            altura = pessoaFromDB.altura.toString()
            textoBotao = "Editar"
        }

    }
    val coroutineScope = rememberCoroutineScope()
    fun onEvent(event: AddEditEvent){
        when(event){
            AddEditEvent.Save ->{
                coroutineScope.launch {
                    pessoaRepository.insert(
                        id = pessoaID,
                        nome = nome,
                        peso = peso.toDouble(),
                        altura = altura.toDouble()
                    )
                }
            }
        }
    }
    Scaffold(
        floatingActionButton = {
            val pessoa: Pessoa?
            var enable: Boolean
            @Composable
            fun semEvento(){
                return FloatingActionButton(
                    onClick = {
                    },
                    containerColor = Color.LightGray
                ) {
                    Icon(
                        Icons.Default.Done,
                        contentDescription = ""
                    )
                }
            }
            if (nome.isNotBlank() && peso.toDoubleOrNull() != null && altura.toDoubleOrNull() != null) {
                pessoa = Pessoa(
                    id = 0,
                    nome = nome,
                    peso = peso.toDouble(),
                    altura = altura.toDouble()
                )
                FloatingActionButton(
                    onClick = {
                        onEvent(AddEditEvent.Save)
                        onBack()
                    }
                ) {
                    Icon(
                        Icons.Default.Done,
                        contentDescription = ""
                    )
                }
                if (pessoa.calcularIMC().valor.isInfinite()){
                    semEvento()
                }

                imc = DecimalFormat("#.##").format(pessoa.calcularIMC().valor)

                if ((altura.toDouble().equals(0.0) || !altura.toDouble().equals(0.0)) && peso.toDouble().equals(0.0)){
                    semEvento()
                }
                if (altura.toDouble().equals(-0.0) || peso.toDouble().equals(-0.0)){
                    semEvento()
                }
                if (altura.toDouble() < 0 || peso.toDouble() < 0){
                    semEvento()
                }

            } else {
                semEvento()
                imc = ""
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .consumeWindowInsets( paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Calculadora de IMC",
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color(0xFFFF1744)
                    )
                )
                OutlinedTextField(
                    value = nome,
                    onValueChange = {
                        nome = it
                    },
                    label = { Text("Nome") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
                OutlinedTextField(
                    value = peso,
                    onValueChange = {
                        peso = it
                    },
                    label = { Text("Peso") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                OutlinedTextField(
                    value = altura,
                    onValueChange = {
                        altura = it
                    },
                    label = { Text("Altura") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Text("IMC: $imc")
            }
        }
    }

}

@Preview
@Composable
private fun AddEditWithPessoaPreview() {
    AddEditPessoa(
        pessoaID = null,
        onBack = {}
    )
}

@Preview
@Composable
private fun AddEditNoPessoaPreview() {
    AddEditPessoa(
        pessoaID = pessoa.id,
        onBack = {}
    )
}