package br.edu.ifsp.listatarefa.data

import androidx.compose.runtime.mutableStateListOf
import br.edu.ifsp.listatarefa.domain.Task

object TaskDataSource {
    val tasks = mutableStateListOf<Task>()
    var currentID: Long = 0
}