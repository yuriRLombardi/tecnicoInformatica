package br.edu.ifsp.hto.lista_tarefas.data

import br.edu.ifsp.hto.lista_tarefas.data.remote.ApiClient.taskService
import br.edu.ifsp.hto.lista_tarefas.domain.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class TaskRepositoryImpl() : TaskRepository {

    override suspend fun insert(title: String, description: String?, id: Long?) {
        if (id != null){
            val task = getById(
                id = id
            )
            taskService.update(
                id = id,
                task = task.copy(
                    title = title,
                    description = description
                )
            )

        }
        else{
            taskService.create(
                Task(
                    id = 0,
                    title = title,
                    description = description,
                    isFinished = false
                )
            )
        }
    }

    override suspend fun updateIsFinished(id: Long, isFinished: Boolean) {
        val task = getById(
            id = id
        )
        if (task != null){
            taskService.update(
                id = id,
                task = task.copy(
                    isFinished = isFinished
                )
            )
        }
    }

    override suspend fun delete(id: Long) {
        return taskService.deleteTask(
            id = id
        )
    }

    override fun getAll(): Flow<List<Task>> {
        return flow {
            val tasks = taskService.getAll()
            emit(tasks)
        }
    }

    override suspend fun getById(id: Long): Task {
        return taskService.getById(
            id = id
        )
    }
}