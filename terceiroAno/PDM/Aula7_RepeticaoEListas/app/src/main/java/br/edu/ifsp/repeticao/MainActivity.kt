package br.edu.ifsp.repeticao
/*
* Nome:Yuri
* Data:19/03/25
* */
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.repeticao.ui.theme.RepeticaoTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RepeticaoTheme {
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
    fun gerarListaAleatoria(tamanho: Int): List<String> {
        val lista = mutableListOf<String>()
        val caracteres = ('a'..'z') + ('A'..'Z')
        for (i in 1..tamanho) {
            val tamanhoString = Random.nextInt(5, 10)
            val strAleatoria = (1..tamanhoString)
                .map { caracteres.random() }
                .joinToString("")
            lista.add(strAleatoria)
        }
        return lista
    }
    Column(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val tamanho = 100
        var list = gerarListaAleatoria(tamanho)
        for (i in list){
            Text(i)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Lista() {
    RepeticaoTheme {
        Greeting("Android")
    }
}