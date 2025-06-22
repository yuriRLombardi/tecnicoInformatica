package br.edu.ifsp.hto.projeto01classe.domain

data class Pessoa(val id: Long, val nome: String, val peso: Double, val altura: Double) {

    fun calcularIMC(): IMC {
        var valorImc = peso / (altura * altura)
        if (valorImc.isNaN()) {
            valorImc = 0.0
        }

        val situacaoIMC = when {
            valorImc < 18.5 -> "Magreza"
            valorImc <= 24.9 -> "Normal"
            valorImc <= 29.9 -> "Sobrepeso"
            valorImc <= 39.9 -> "Obesidade"
            else -> "Obesidade grave"
        }

        return IMC(
            valor = valorImc,
            situacao = situacaoIMC
        )
    }
}

val pessoa = Pessoa(
    id = 1,
    nome = "Jubileu",
    peso = 80.0,
    altura = 2.2
)
