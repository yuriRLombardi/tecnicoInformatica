package com.example.qualvaleapena

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qualvaleapena.ui.theme.QualValeAPenaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QualValeAPenaTheme {
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
fun calcularUnidade(preco:String,unidade: String):Double{
    if (preco.isBlank() || unidade.isBlank()){
        return 0.0
    }
    else if (preco.toDoubleOrNull() == null || unidade.toIntOrNull() == null){
       return 0.0
    }
    else{
        return preco.toDouble()/unidade.toInt();
    }
}
fun vantagioso(valorUnit1:Double,valorUnit2: Double,uni1:String,uni2:String):String{
    var s1 = ""
    var s2 = ""
    if (uni1.isBlank() || uni2.isBlank()){
        return ""
    }
    else if (uni1.toDoubleOrNull() == null || uni2.toIntOrNull() == null){
        return ""
    }
    if (uni1.toInt() == 1){
        s1 = "unidade"
    }
    else{
        s1 = "unidades"
    }

    if (uni2.toInt() == 1){
        s2 = "unidade"
    }
    else{
        s2 = "unidades"
    }

    if (valorUnit1 < valorUnit2){
        return "O Produto 1 é mais vantajoso com ${uni1} ${s1}"
    }
    else if(valorUnit2 < valorUnit1){
        return "O Produto 2 é mais vantajoso com ${uni2} ${s2}"
    }
    else{
        return "Tanto faz"
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var preco1 by remember { mutableStateOf("") }
    var preco2 by remember { mutableStateOf("") }
    var unidade1 by remember { mutableStateOf("") }
    var unidade2 by remember { mutableStateOf("") }
    var valorUni1 by remember { mutableStateOf(0.0) }
    var valorUni2 by remember { mutableStateOf(0.0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .safeDrawingPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Qual vale a pena?",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(Modifier.padding(20.dp))
        Text("Produto 1")
        OutlinedTextField(
            value = preco1,
            onValueChange = {preco1 = it},
            label = { Text("Preço") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = unidade1,
            onValueChange = {unidade1 = it},
            label = { Text("Unidades") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        valorUni1 = calcularUnidade(preco1,unidade1)
        Spacer(Modifier.padding(8.dp))
        HorizontalDivider()

        Text("Produto 2")
        OutlinedTextField(
            value = preco2,
            onValueChange = {preco2 = it},
            label = { Text("Preço") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = unidade2,
            onValueChange = {unidade2 = it},
            label = { Text("Unidades") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        valorUni2 = calcularUnidade(preco2,unidade2)
        Spacer(Modifier.padding(8.dp))
        HorizontalDivider()
        Text(vantagioso(valorUni1,valorUni2,unidade1,unidade2))
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QualValeAPenaTheme {
        Greeting("Android")
    }
}