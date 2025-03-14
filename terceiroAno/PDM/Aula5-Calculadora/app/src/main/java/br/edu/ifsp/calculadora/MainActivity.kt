package br.edu.ifsp.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.ifsp.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraTheme {
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
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var res by remember { mutableStateOf(0.0) }
Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    Text(
        text = "Calculadora",
    )
    TextField(
        value = num1,
        onValueChange = { num1 = it },
        label = { Text("Numero 1") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    TextField(
        value = num2,
        onValueChange = { num2 = it },
        label = { Text("Numero 2") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    Row(modifier.padding(2.dp)) {
        Button(onClick = {res = num1.toDouble() + num2.toDouble()}) { Text("+")}
        Button(onClick = {res = num1.toDouble() - num2.toDouble()}) {Text("-") }
        Button(onClick = {res = num1.toDouble() * num2.toDouble()}) {Text("x") }
        Button(onClick = {res= num1.toDouble() / num2.toDouble()}) { Text("/")}
    }
    Text("Resultado: $res")

}
}

@Preview(showBackground = true)
@Composable
fun OperacoesBasicas() {
    CalculadoraTheme {
        Greeting("Android")
    }
}