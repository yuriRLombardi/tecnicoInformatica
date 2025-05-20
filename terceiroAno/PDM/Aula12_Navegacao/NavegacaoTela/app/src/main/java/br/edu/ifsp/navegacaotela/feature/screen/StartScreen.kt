package br.edu.ifsp.navegacaotela.feature.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun StartScreen(
    navigationSecondScreen:(message:String?) -> Unit
) {
    var mensagem by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Primeira tela",
            style = TextStyle(
                fontSize = 32.sp
            )
        )
        OutlinedTextField(
            value = mensagem,
            onValueChange = {mensagem = it},
            label = {
                Text("Digite uma mensagem")
            }
        )
        Button(
            onClick = {
                navigationSecondScreen(mensagem)
            }
        ) {
            Text("Ir para segunda tela")
        }
    }
}



@Preview
@Composable
private fun StartScreenPreview() {
    StartScreen(
        navigationSecondScreen = {}
    )
}