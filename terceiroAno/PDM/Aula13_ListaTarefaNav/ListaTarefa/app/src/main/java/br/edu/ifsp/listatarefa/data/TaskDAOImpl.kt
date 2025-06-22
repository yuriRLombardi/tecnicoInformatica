package br.edu.ifsp.listatarefa.data


import br.edu.ifsp.listatarefa.domain.Task

class TaskDAOImpl : TaskDAO {
    private val tasks = TaskDataSource.tasks
    override fun insert(task: Task) {
        tasks.add(task.copy(TaskDataSource.currentID++))
    }

    override fun delete(task: Task) {
        val taskToRemove = getTaskByID(task.id)
        if (taskToRemove != null) {
            tasks.remove(taskToRemove)
        }
    }

    override fun update(task: Task) {
        val index = tasks.indexOfFirst { it.id == task.id }

        if (index != -1) {
            tasks[index] = task
        }
    }

    override fun getAllTask(): List<Task> {
        return tasks
    }

    override fun getTaskByID(id: Long): Task? {
        val index = tasks.indexOfFirst { it.id == id }

        if (index != -1) {
            return tasks[index]
        }

        return null
    }
}
