package br.edu.ifsp.exemplodataclass

import android.os.Bundle
import android.view.textclassifier.SelectionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.ifsp.exemplodataclass.model.Tarefa
import br.edu.ifsp.exemplodataclass.model.tarefa1
import br.edu.ifsp.exemplodataclass.model.tarefa2
import br.edu.ifsp.exemplodataclass.model.tarefa3
import br.edu.ifsp.exemplodataclass.ui.theme.ExemploDataClassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExemploDataClassTheme {
                Box(
                    modifier = Modifier
                        .safeDrawingPadding()
                ){
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val tarefas : MutableList<Tarefa> = mutableListOf<Tarefa>()
    tarefas.add(tarefa1)
    tarefas.add(tarefa2)
    tarefas.add(tarefa3)
    //val tarefa2 = Tarefa(1,"titulo",null,false)
    Column {
        Text("Lista de Tarefas")
        for(tarefa in tarefas){
            TarefaCard(tarefa)
        }
    }
}

@Composable
fun TarefaCard(tarefa:Tarefa) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Checkbox(
                checked = tarefa.ehFinalizada,
                onCheckedChange = {}
            )
            Column {
                Text(
                    tarefa.titulo,
                    style = MaterialTheme.typography.titleLarge
                )
                if (tarefa.descricao != null) {
                    Text(
                        tarefa.descricao,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExemploDataClassTheme {
        Greeting()
    }
}