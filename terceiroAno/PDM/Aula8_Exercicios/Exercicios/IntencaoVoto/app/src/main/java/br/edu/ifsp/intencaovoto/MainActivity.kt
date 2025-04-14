package br.edu.ifsp.intencaovoto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.intencaovoto.ui.theme.IntencaoVotoTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntencaoVotoTheme {
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
    var c1 by remember { mutableStateOf(0.0) }
    var c2 by remember { mutableStateOf(0.0) }
    var c3 by remember { mutableStateOf(0.0) }
    var res1 by remember { mutableStateOf("") }
    var res2 by remember { mutableStateOf("") }
    var res3 by remember { mutableStateOf("") }

    fun calcularVotos(voto:Double,total:Double):String{

        var porcentagem = round((voto/total) *100)

        return porcentagem.toString()
    }
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Intenção de Voto",
                fontSize = 20.sp
            )
            Button(onClick = {c1++}) { Text("Candidado 1") }
            Button(onClick = {c2++}) { Text("Candidado 2") }
            Button(onClick = {c3++}) { Text("Candidado 3") }
            Button(
                onClick = {
                    var total = c1 + c2 + c3
                    res1 = " -Total: "+c1+" Porcentagem: "+calcularVotos(c1,total)+"%"
                    res2 = " -Total: "+c2+" Porcentagem: "+calcularVotos(c2,total)+"%"
                    res3 = " -Total: "+c3+" Porcentagem: "+calcularVotos(c3,total)+"%"
                }
            )
            { Text("Totalizar") }
            HorizontalDivider()
            Text(
                text = "Resultados",
                fontSize = 20.sp
            )
            Text("Canditado 1"+res1)
            Text("Canditado 2"+res2)
            Text("Canditado 3"+res3)

        }
    }

}

@Preview(showBackground = true)
@Composable
fun IntencaoVoto() {
    IntencaoVotoTheme {
        Greeting("Android")
    }
}