package br.edu.ifsp.exemplodataclass.model

data class Tarefa(
    val id: Long,
    val titulo: String,
    val descricao: String?,
    val ehFinalizada: Boolean
)

/* Fake data */
val tarefa1 = Tarefa(
    id = 1,
    titulo = "Tarefa1",
    descricao = null,
    ehFinalizada = true
)

val tarefa2 = Tarefa(
    id = 1,
    titulo = "Tarefa2",
    descricao = "Descrição da Tarefa 2",
    ehFinalizada = false
)

val tarefa3 = Tarefa(
    id = 3,
    titulo = "Tarefa3",
    descricao = "Descrição da Tarefa 3",
    ehFinalizada = true
)