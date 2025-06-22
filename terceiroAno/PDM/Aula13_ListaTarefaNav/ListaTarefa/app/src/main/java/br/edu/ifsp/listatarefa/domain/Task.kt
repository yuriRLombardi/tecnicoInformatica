package br.edu.ifsp.listatarefa.domain


data class Task(
    val id: Long,
    val title: String,
    val description: String?,
    val isFinished: Boolean
)

val task1 = Task(
    id = 1,
    title = "Task 1",
    description = "Description Task 1",
    isFinished = true
)

val task2 = Task(
    id = 2,
    title = "Task 2",
    description = "Description Task 2",
    isFinished = false
)
val task3 = Task(
    id = 3,
    title = "Task 3",
    description = null,
    isFinished = false
)
