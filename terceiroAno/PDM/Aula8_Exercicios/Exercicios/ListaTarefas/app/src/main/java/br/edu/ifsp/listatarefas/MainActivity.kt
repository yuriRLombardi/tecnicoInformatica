package br.edu.ifsp.listatarefas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.ifsp.listatarefas.ui.theme.ListaTarefasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaTarefasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val lista = remember { mutableStateListOf<String>() }
    var tarefa by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .verticalScroll(ScrollState(Int.MAX_VALUE))
    ) {
        Row {
            OutlinedTextField(
                onValueChange = { tarefa = it },
                value = tarefa
            )
            Button(onClick = {
                lista.add(tarefa)
            }) { Text("Inserir Tarefa") }
        }
       lista.forEach{
           tarefas -> Text(tarefas)
           Spacer(modifier = Modifier.size(20.dp))
           HorizontalDivider()
       }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaTarefas() {
    ListaTarefasTheme {
        Greeting("Android")
    }
}