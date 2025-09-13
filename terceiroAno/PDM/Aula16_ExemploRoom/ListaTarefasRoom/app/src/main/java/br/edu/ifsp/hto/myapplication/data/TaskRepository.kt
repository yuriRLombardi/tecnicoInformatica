package br.edu.ifsp.hto.myapplication.data

import br.edu.ifsp.hto.myapplication.domain.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun insert(id: Long?, title: String, description: String?)

    suspend fun delete(id: Long)

    fun getAll(): Flow<List<Task>>

    suspend fun getById(id: Long): Task?

    suspend fun isFinishedChanged(id: Long, isFinished: Boolean)
}