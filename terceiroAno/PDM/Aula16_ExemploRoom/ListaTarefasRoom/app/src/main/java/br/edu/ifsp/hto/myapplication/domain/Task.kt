package br.edu.ifsp.hto.myapplication.domain

// TODO(6) Definir a data class abaixo para representar uma tarefa (Task)
data class Task(
    val id: Long,
    val title: String,
    val description: String?,
    val isFinished: Boolean
)

// TODO(7) Definimos as tarefas abaixo apenas para usar na prévia das telas.
val task1 = Task(
    id = 1,
    title = "Tarefa 1",
    description = "Desc Tarefa 1",
    isFinished = true
)

val task2 = Task(
    id = 2,
    title = "Tarefa 2",
    description = "Desc Tarefa 2",
    isFinished = false
)

val task3 = Task(
    id = 3,
    title = "Tarefa 3",
    description = null,
    isFinished = false
)


