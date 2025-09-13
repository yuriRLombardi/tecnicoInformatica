package br.edu.ifsp.hto.myapplication.data

import br.edu.ifsp.hto.myapplication.domain.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepositoryImpl(
    private val dao: TaskDAO
) : TaskRepository {

    override suspend fun insert(
        id: Long?,
        title: String,
        description: String?
    ) {
        if (id == null) {
            val taskEntity = TaskEntity(
                title = title,
                description = description,
                isFinished = false
            )
            dao.insert(taskEntity)
        } else {
            val taskEntity = dao.getById(id)
            if (taskEntity != null) {
                val updatedEntity = taskEntity.copy(
                    title = title,
                    description = description,
                )
                dao.insert(updatedEntity)
            }
        }
    }

    override suspend fun delete(id: Long) {
        val exitingEntity = dao.getById(id) ?: return
        dao.delete(exitingEntity)
    }

    override fun getAll(): Flow<List<Task>> {
        return dao.getAll().map { taskEntities: List<TaskEntity> ->
            taskEntities.map { taskEntity: TaskEntity ->
                Task(
                    id = taskEntity.id,
                    title = taskEntity.title,
                    description = taskEntity.description,
                    isFinished = taskEntity.isFinished
                )
            }
        }
    }

    override suspend fun getById(id: Long): Task? {
        val existingEntity = dao.getById(id)
        if (existingEntity != null) {
            return Task(
                id = existingEntity.id,
                title = existingEntity.title,
                description = existingEntity.description,
                isFinished = existingEntity.isFinished
            )
        }
        return null
    }

    override suspend fun isFinishedChanged(id: Long, isFinished: Boolean) {
        val existingTask = dao.getById(id = id) ?: return
        dao.insert(
            taskEntity = existingTask.copy(isFinished = isFinished)
        )
    }

}