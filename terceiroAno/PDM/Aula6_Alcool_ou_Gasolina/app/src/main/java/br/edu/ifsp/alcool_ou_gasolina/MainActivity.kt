package br.edu.ifsp.alcool_ou_gasolina
/*
* App para calcular qual o melhor se é alcool ou gasolina
* Nome: Yuri
* Data: 17/03/25
* */
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.alcool_ou_gasolina.ui.theme.Alcool_ou_GasolinaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Alcool_ou_GasolinaTheme {
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
    var resultado by remember { mutableStateOf("") }

    //Método que compara se o álccol é menor que 70% da galsolina
    fun calcular(a: Double, g: Double): String {
        if (a < (g * 0.70)) {
            return "Álcool"
        } else {
            return "Gasolina"
        }
    }

    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    Column(
        Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFF2196F3)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        try {
            if (num1.isBlank() || num2.isBlank()) {
                resultado = ""
            } else {
                resultado = calcular(num1.toDouble(), num2.toDouble())
            }
        } catch (e: NumberFormatException) {
            resultado = "ERRO"
        }
        Text(
            text = "Álcool ou Gasolina?",
            style = TextStyle(
                color = Color(0xFFFFFFFF),
                fontSize = 32.sp
            )
        )
        Text(
            text = resultado,
            style = TextStyle(
                color = Color(0xFFFF0000),
                fontSize = 40.sp
            )
        );
        TextField(
            value = num1,
            label = {
                Text("Preço do Álcool")
            },
            onValueChange = {
                num1 = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(Modifier.size(15.dp))
        TextField(
            value = num2,
            label = { Text("Preço da Gasolina") },
            onValueChange = {
                num2 = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Escolha() {
    Alcool_ou_GasolinaTheme {
        Greeting("")
    }
}