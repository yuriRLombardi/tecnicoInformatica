package com.example.mist.domain

import java.time.Year

data class Jogo(
    val id: Int,
    val nome: String,
    val preco: Float,
    val ano: Year,
)
