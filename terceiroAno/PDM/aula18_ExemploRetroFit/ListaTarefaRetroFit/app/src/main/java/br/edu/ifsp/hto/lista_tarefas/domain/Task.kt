package br.edu.ifsp.hto.lista_tarefas.domain

import com.squareup.moshi.Json

data class Task(
    val id: Long,
    val title: String,
    val description: String?,
    @Json(name = "is_finished")
    val isFinished: Boolean
)

// fake data
val task1 = Task(
    id = 1,
    title = "Tarefa 1",
    description = "Descrição da Tarefa 1",
    isFinished = true
)

val task2 = Task(
    id = 2,
    title = "Tarefa 2",
    description = null,
    isFinished = false
)

val task3 = Task(
    id = 3,
    title = "Tarefa 3",
    description = "Descrição da Tarefa 3",
    isFinished = false
)