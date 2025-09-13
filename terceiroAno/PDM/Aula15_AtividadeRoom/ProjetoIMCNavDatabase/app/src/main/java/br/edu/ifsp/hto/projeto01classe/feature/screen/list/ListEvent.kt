package br.edu.ifsp.hto.projeto01classe.feature.screen.list

sealed interface ListEvent {
    data class AddEdit(val id:Long?) : ListEvent
    data class Delete(val id: Long) : ListEvent
}