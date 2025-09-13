package br.edu.ifsp.hto.myapplication.feature.screen.addedit

// TODO(27) Criar uma interface selada para definir os eventos (ações) que ocorrem na tela de
//  inserção/edição de uma tarefa.
sealed interface AddEditEvent {
    // TODO(28) Este data object representa o evento de inserção/edição.
    data object Save : AddEditEvent
    data class TitleChanged(val title: String):AddEditEvent
    data class DescriptionChanged(val description: String): AddEditEvent
}