package com.example.mist.domain

import java.time.Year

data class Console(
    val id: Int,
    val nome: String,
    val preco: Float,
    val ano: Year,
)
