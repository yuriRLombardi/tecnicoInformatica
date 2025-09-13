package br.edu.ifsp.hto.lista_tarefas.utils

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class BooleanAdapter {
    @FromJson
    fun fromJason(value: Int): Boolean{
        return value != 0
    }

    @ToJson
    fun toJason(value: Boolean): Int {
        return if (value) 1 else 0
    }
}