package br.edu.ifsp.hto.projeto01classe.feature.screen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.ifsp.hto.projeto01classe.data.PessoaDAO
import br.edu.ifsp.hto.projeto01classe.domain.Pessoa
import br.edu.ifsp.hto.projeto01classe.domain.pessoa

@Composable
fun ListScreen(
    pessoaDAO: PessoaDAO,
    navigationAddEditPessoa: (id: Long?) -> Unit
) {
    ListScreenContent(
        pessoaDAO.getAllPessoa(),
        navigationAddEditPessoa = navigationAddEditPessoa,
        onRemove = { id ->
            val pessoaFromList = pessoaDAO.getPessoaById(id)
            if (pessoaFromList != null) {
                pessoaDAO.delete(pessoaFromList)
            }
        }
    )
}

@Composable
fun ListScreenContent(
    pessoa: List<Pessoa>,
    navigationAddEditPessoa: (id: Long?) -> Unit,
    onRemove: (id: Long) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navigationAddEditPessoa(null)
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
                    onRemove = onRemove,
                    navigationAddEditPessoa = navigationAddEditPessoa
                )
            }
        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun PessoaCard(
    pessoa: Pessoa,
    onRemove: (id: Long) -> Unit,
    navigationAddEditPessoa: (id: Long?) -> Unit
) {
    val imc = pessoa.calcularIMC()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = {
            navigationAddEditPessoa(pessoa.id)
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
                    onRemove(pessoa.id)
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
        navigationAddEditPessoa = {},
        onRemove = {}
    )
}
