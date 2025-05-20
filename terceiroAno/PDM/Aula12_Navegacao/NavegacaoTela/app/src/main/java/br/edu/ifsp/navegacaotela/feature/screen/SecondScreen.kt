package br.edu.ifsp.navegacaotela.feature.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(
    message:String?,
    onBack:() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Segunda tela",
            style = TextStyle(
                fontSize = 32.sp
            )
        )
        Text(message?:"")
        Button(
            onClick = onBack
        ) {
            Text("Voltar")
        }
    }
}

@Preview
@Composable
private fun SecondScreenPreview() {
    SecondScreen(
        message = "Mensagem",
        onBack = {}
    )
}