package br.edu.ifsp.calculadoranavegacao.feature.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.calculadoranavegacao.CalcOperacoes

@Composable
fun TelaOperacoes(
    num1:Float,
    num2: Float,
    onBack:() -> Unit
) {
    var resultado = CalcOperacoes(num1,num2)
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Segunda Tela",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.Red
            )
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Soma: ${resultado.soma()}")
            Text("Subtração: ${resultado.subtracao()}")
            Text("Multiplicação: ${resultado.multiplicacao()}")
            Text("Divisão: ${resultado.divisao()}")
        }
        Button(
            onClick = onBack
        ) {
            Text("Voltar")
        }
    }
}

@Preview
@Composable
private fun TelaOperacoesPreview() {
    TelaOperacoes(num1 = 0.0f, num2 = 0.0f, onBack = {})
}