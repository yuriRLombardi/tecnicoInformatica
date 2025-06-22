package br.edu.ifsp.listatarefa.data

import br.edu.ifsp.listatarefa.domain.Task

interface TaskDAO {
    fun insert(task: Task)
    fun delete(task: Task)
    fun update(task: Task)
    fun getAllTask(): List<Task>
    fun getTaskByID(id: Long): Task?
}