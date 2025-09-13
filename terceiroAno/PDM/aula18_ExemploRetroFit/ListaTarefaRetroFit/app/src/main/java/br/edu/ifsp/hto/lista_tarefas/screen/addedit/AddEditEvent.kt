package br.edu.ifsp.hto.lista_tarefas.screen.addedit

sealed interface AddEditEvent {
    data class TitleChanged(val title: String) : AddEditEvent
    data class DescriptionChanged(val description: String) : AddEditEvent
    data object Save : AddEditEvent
}