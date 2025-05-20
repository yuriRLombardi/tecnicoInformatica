package br.edu.ifsp.calculadoranavegacao.feature.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.sp

@Composable
fun TelaValores(
    navigationTelaOperacoes:(num1:Float,num2:Float) -> Unit
) {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Primeira Tela",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.Red
            )
        )
        OutlinedTextField(
            value = num1,
            onValueChange = {num1 = it},
            label = { Text("Digite o Primeiro Valor") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = num2,
            onValueChange = {num2 = it},
            label = { Text("Digite o Segundo Valor") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
            onClick = {
                navigationTelaOperacoes(num1.toFloat(),num2.toFloat())
            }
        ) {
            Text("Calcular");
        }
    }
}


@Preview
@Composable
private fun TelaValoresPreviem() {
    TelaValores(
        navigationTelaOperacoes = { fl: Float?, fl1: Float? -> }
    )
}