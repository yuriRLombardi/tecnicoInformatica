package br.edu.ifsp.hto.lista_tarefas.data

import br.edu.ifsp.hto.lista_tarefas.domain.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun insert(title: String, description: String?, id: Long? = null)

    suspend fun updateIsFinished(id: Long, isFinished: Boolean)

    suspend fun delete(id: Long)

    fun getAll(): Flow<List<Task>>

    suspend fun getById(id: Long): Task?
}