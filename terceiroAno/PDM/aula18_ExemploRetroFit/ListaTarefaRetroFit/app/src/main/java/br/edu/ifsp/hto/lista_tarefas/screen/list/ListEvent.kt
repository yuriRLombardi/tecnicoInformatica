package br.edu.ifsp.hto.lista_tarefas.screen.list

sealed interface ListEvent {
    data class Delete(val id: Long) : ListEvent
    data class IsFinishedChanged(val id: Long, val isFinished: Boolean) : ListEvent
    data class AddEdit(val id: Long?) : ListEvent
}