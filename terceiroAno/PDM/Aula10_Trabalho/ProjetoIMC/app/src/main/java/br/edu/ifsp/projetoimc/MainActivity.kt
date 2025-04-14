package br.edu.ifsp.projetoimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.CreationExtras
import br.edu.ifsp.projetoimc.ui.theme.ProjetoIMCTheme
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjetoIMCTheme {
                Greeting()
            }
        }
    }
}

fun calcularIMC(peso: Double, altura: Double): Double {

    var imc = peso / (altura.pow(2))

    if (imc.isNaN()) {
        return 0.0;
    }
    else if (imc.isInfinite()){
        return 0.0
    }
    else if (imc < 0){
        return  0.0
    }
    else {
        return imc;
    }
}

fun situacao(imc: Double): String {
    var situacao = ""
    when (imc) {
        in 0.0..18.4 -> situacao = "Magreza"
        in 18.5..24.9 -> situacao = "Normal"
        in 25.0..29.9 -> situacao = "Sobrepeso"
        in 30.0..39.9 -> situacao = "Obsidade"
        else -> situacao = "Obsidade Grave"
    }
    return situacao
}

@Composable
fun Greeting() {
    var nome by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    val listaPessoas = remember { mutableStateListOf<Pessoa>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = "Calculadora IMC",
            style = TextStyle(
                color = Color.Red,
                fontSize = 40.sp,
                fontStyle = FontStyle.Italic
            )
        )
        OutlinedTextField(
            onValueChange = { nome = it },
            value = nome,
            label = { Text("Nome") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        OutlinedTextField(
            onValueChange = { peso = it },
            value = peso,
            label = { Text("Peso") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            onValueChange = { altura = it },
            value = altura,
            label = { Text("Altura") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        var pesoD = 0.0
        var alturaD = 0.0

        if (peso.isNotEmpty() && altura.isNotEmpty()) {
            pesoD = peso.toDouble()
            alturaD = altura.toDouble()
        }

        Text(
            text = "IMC: " + String.format("%.2f", calcularIMC(pesoD, alturaD)),
            style = TextStyle(
                fontSize = 30.sp
            )
        )

        var imc = String.format("%.2f", calcularIMC(pesoD, alturaD))

        Button(onClick = {
            val pessoa = Pessoa(nome, pesoD, alturaD, imc.toDouble(), situacao(imc.toDouble()))
            listaPessoas.add(pessoa)
        }) { Text("Adicionar") }
        HorizontalDivider()
        LazyColumn {
            items(listaPessoas) { pessoa ->
                gerarCardIMC(
                    pessoa.nome,
                    pessoa.peso,
                    pessoa.altura,
                    pessoa.imc.toString(),
                    pessoa.situacao
                )
            }
        }
    }
}

@Composable
fun gerarCardIMC(nome: String, peso: Double, altura: Double, imc: String, situacao: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = nome,
                style = MaterialTheme.typography.titleLarge
            );
            when (situacao) {
                "Magreza" -> Text(
                    text = "Situação: " + situacao,
                    style = TextStyle(color = Color.Blue)
                )

                "Normal" -> Text(
                    text = "Situação: " + situacao,
                    style = TextStyle(color = Color(0, 178, 2, 255))
                )

                "Sobrepeso" -> Text(
                    text = "Situação: " + situacao,
                    style = TextStyle(color = Color(255, 255, 141, 255))
                )

                "Obsidade" -> Text(
                    text = "Situação: " + situacao,
                    style = TextStyle(color = Color(255, 152, 0, 255))
                )

                "Obsidade Grave" -> Text(
                    text = "Situação: " + situacao,
                    style = TextStyle(color = Color.Red)
                )
            }

            Text("Peso: " + peso)
            Text("Altura: " + altura)
            Text("IMC: " + imc)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjetoIMCTheme {
        Greeting()
    }
}