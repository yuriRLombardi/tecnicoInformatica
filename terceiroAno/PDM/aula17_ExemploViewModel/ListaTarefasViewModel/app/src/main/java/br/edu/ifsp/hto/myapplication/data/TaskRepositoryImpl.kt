package br.edu.ifsp.hto.myapplication.data

import br.edu.ifsp.hto.myapplication.domain.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// TODO(20) Esta classe implementa a interface TaskRepository.
class TaskRepositoryImpl(
    private val dao: TaskDAO
) : TaskRepository {

    // TODO(21) Este método realiza tanto a inserção quanto a atualização de uma Task.
    override suspend fun insert(
        id: Long?,
        title: String,
        description: String?
    ) {
        // TODO(22) Se o id for nulo então trata-se de uma inserção, caso contrário uma atualizção.
        if (id == null) {
            val taskEntity = TaskEntity(
                title = title,
                description = description,
                isFinished = false
            )
            dao.insert(taskEntity)
        } else {
            // TODO(23) Para a atualização, recuperamos primeiro a Task do Banco de Dados.
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
        // TODO(24) Para a remoção, verificamos primeiro se a Task existe no BD.
        val exitingEntity = dao.getById(id) ?: return
        dao.delete(exitingEntity)
    }

    // TODO(25) O DAO retorna uma lista de TaskEntity, mas o método retorna uma lista de Task.
    //  Por essa razão temos que fazer a conversão dessa lista de TaskEntity para uma lista de Task.
    //  O map é utilizado para isso.
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

    // TODO(26) Este método atualiza uma Task existente para indicá-la como concluída ou não.
    // Ao clicar no checkbox este método deve ser chamado para atualizar a situação de uma Task.
    override suspend fun isFinishedChanged(id: Long, isFinished: Boolean) {
        val existingTask = dao.getById(id = id) ?: return
        dao.insert(
            taskEntity = existingTask.copy(isFinished = isFinished)
        )
    }

}