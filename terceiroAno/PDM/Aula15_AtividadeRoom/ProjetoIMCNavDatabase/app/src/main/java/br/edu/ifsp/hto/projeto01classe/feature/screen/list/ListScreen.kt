package br.edu.ifsp.hto.projeto01classe.feature.screen.list

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.ifsp.hto.projeto01classe.data.PessoaDAO
import br.edu.ifsp.hto.projeto01classe.data.PessoaDatabaseProvider
import br.edu.ifsp.hto.projeto01classe.data.PessoaRepositoryImpl
import br.edu.ifsp.hto.projeto01classe.domain.Pessoa
import br.edu.ifsp.hto.projeto01classe.domain.pessoa
import kotlinx.coroutines.launch

@Composable
fun ListScreen(
    navigationAddEditPessoa: (id: Long?) -> Unit
) {
    val context = LocalContext.current.applicationContext
    val database = PessoaDatabaseProvider.provide(context = context)
    val pessoaRepository = PessoaRepositoryImpl(daoRoom = database.pessoaDAO())

    val pessoaFlow = pessoaRepository.getAllPessoa()
    val pessoa = pessoaFlow.collectAsState(initial = emptyList())

    val coroutineScope = rememberCoroutineScope()

    fun onEvent(event: ListEvent){
        when(event){
            is ListEvent.AddEdit -> {
                navigationAddEditPessoa(event.id)
            }
            is ListEvent.Delete -> {
                coroutineScope.launch {
                    pessoaRepository.delete(event.id)
                }
            }
        }
    }
    ListScreenContent(
        pessoa = pessoa.value,
        onEvent = {event ->
            onEvent(event = event)
        }
    )
}

@Composable
fun ListScreenContent(
    pessoa: List<Pessoa>,
    onEvent: (event: ListEvent) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEvent(
                        ListEvent.AddEdit(
                            id = null
                        )
                    )
                }
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .consumeWindowInsets(paddingValues)
        ) {
            items(pessoa) { pessoa ->
                PessoaCard(
                    pessoa = pessoa,
                    onEvent = onEvent
                )
            }
        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun PessoaCard(
    pessoa: Pessoa,
    onEvent: (event: ListEvent) -> Unit
) {
    val imc = pessoa.calcularIMC()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = {
            onEvent(
                ListEvent.AddEdit(id = pessoa.id)
            )
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    pessoa.nome,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    "Situação: ${imc.situacao}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (imc.valor < 18.5) Color.Blue else if (imc.valor < 25) Color.Green else Color.Red
                )
                Text(
                    "Peso: ${pessoa.peso}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    "Altura: ${pessoa.altura}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    "IMC: ${DecimalFormat("#.##").format(pessoa.calcularIMC().valor)}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Button(
                onClick = {
                    onEvent(
                        ListEvent.Delete(
                            id = pessoa.id
                        )
                    )
                }
            ) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
private fun ListScreenPreview() {
    ListScreenContent(
        listOf(pessoa),
        onEvent = {}
    )
}
