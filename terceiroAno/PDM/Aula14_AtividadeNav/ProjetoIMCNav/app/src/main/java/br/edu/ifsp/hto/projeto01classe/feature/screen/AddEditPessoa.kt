package br.edu.ifsp.hto.projeto01classe.feature.screen

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.enableLiveLiterals
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.hto.projeto01classe.data.PessoaDAO
import br.edu.ifsp.hto.projeto01classe.data.PessoaDAOImpli
import br.edu.ifsp.hto.projeto01classe.domain.Pessoa
import br.edu.ifsp.hto.projeto01classe.domain.pessoa


@SuppressLint("DefaultLocale")
@Composable
fun AddEditPessoa(
    pessoaDAOImpli: PessoaDAO,
    pessoaID: Long?,
    onBack: () -> Unit
) {
    var nome by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var imc by remember { mutableStateOf("") }
    var textoBotao by remember { mutableStateOf("Adicionar") }

    LaunchedEffect(Unit) {

        val pessoaFromList = pessoaID?.let { pessoaDAOImpli.getPessoaById(it) }
        if (pessoaFromList != null) {
            nome = pessoaFromList.nome
            peso = pessoaFromList.peso.toString()
            altura = pessoaFromList.altura.toString()
            textoBotao = "Editar"
        }

    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
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

            val pessoa: Pessoa?
            var enable: Boolean
            if (nome.isNotBlank() && peso.toDoubleOrNull() != null && altura.toDoubleOrNull() != null) {
                pessoa = Pessoa(
                    id = 0,
                    nome = nome,
                    peso = peso.toDouble(),
                    altura = altura.toDouble()
                )
                enable = true
                if (pessoa.calcularIMC().valor.isInfinite()){
                    enable = false
                }

                imc = DecimalFormat("#.##").format(pessoa.calcularIMC().valor)

                if ((altura.toDouble().equals(0.0) || !altura.toDouble().equals(0.0)) && peso.toDouble().equals(0.0)){
                    enable = false
                }
                if (altura.toDouble().equals(-0.0) || peso.toDouble().equals(-0.0)){
                    enable = false
                }
                if (altura.toDouble() < 0 || peso.toDouble() < 0){
                    enable = false
                }

            } else {
                enable = false
                imc = ""
            }

            Button(
                enabled = enable,
                onClick = {
                    if (pessoaID == null) {

                        enable = true
                        val insertPessoa = Pessoa(
                            id = -1,
                            nome = nome,
                            peso = peso.toDouble(),
                            altura = altura.toDouble()
                        )
                        pessoaDAOImpli.insert(insertPessoa)


                    } else {

                        val uptadePessoa = Pessoa(
                            id = pessoaID,
                            nome = nome,
                            peso = peso.toDouble(),
                            altura = altura.toDouble()
                        )
                        pessoaDAOImpli.uptade(uptadePessoa)
                    }
                    onBack()
                }
            ) {
                Text(textoBotao)
            }
        }
    }
}

@Preview
@Composable
private fun AddEditWithPessoaPreview() {
    AddEditPessoa(
        pessoaDAOImpli = PessoaDAOImpli(),
        pessoaID = null,
        onBack = {}
    )
}

@Preview
@Composable
private fun AddEditNoPessoaPreview() {
    val pessoaDAOImpli = PessoaDAOImpli()
    pessoaDAOImpli.insert(pessoa)
    AddEditPessoa(
        pessoaDAOImpli = pessoaDAOImpli,
        pessoaID = pessoa.id,
        onBack = {}
    )
}