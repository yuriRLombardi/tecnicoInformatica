package br.edu.ifsp.hto.myapplication.feature.screen.list

// TODO(41) Definimos uma interface selada com os eventos que ocorrem na tela de listagem. Nesta
//  tela é possível Adiciionar/Editar uma nova Tarefa (AddEdit), Remover (Delete) ou marcar uma
//  Task como finalizada (IsFinishedChanged)
sealed interface ListEvent {
    data class AddEdit(val id: Long?) : ListEvent
    data class Delete(val id: Long) : ListEvent
    data class IsFinishedChanged(val id: Long, val isFinished: Boolean) : ListEvent
}