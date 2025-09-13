package br.edu.ifsp.hto.myapplication.feature.screen.addedit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.ifsp.hto.myapplication.data.TaskRepository
import br.edu.ifsp.hto.myapplication.feature.screen.UIEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AddEditViewModel(
    private val id: Long? = null,
    private val taskRepository: TaskRepository
) : ViewModel() {
    var title by mutableStateOf("")
        private set // Encapsulamento
    var description by mutableStateOf<String?>(null)
        private set // Encapsulamento

    private val _uiEventet = Channel<UIEvent>()
    val uiEvent = _uiEventet.receiveAsFlow()
    init {
        if (id != null){
            viewModelScope.launch {
                val task = taskRepository.getById(id)
                if (task != null){
                    title = task.title
                    description = task.description
                }
                else{
                    title = ""
                    description = ""
                }
            }
        }
    }

    fun onEvent(event: AddEditEvent) {
        when(event){
            is AddEditEvent.DescriptionChanged -> {
                description = event.description
            }
            AddEditEvent.Save -> {
                save()
            }
            is AddEditEvent.TitleChanged -> {
                title = event.title
            }
        }
    }

    //Método para salvar/editar uma tarefa no Banco de Dados
    private fun save(){
        viewModelScope.launch {
            if (title.isNotBlank()) {
                taskRepository.insert(
                    id = id,
                    title = title,
                    description = description
                )
                _uiEventet.send(UIEvent.NavigateBack)
            }
            else{
                // Mostrar uma mensagem de erro para o usuário
                _uiEventet.send(UIEvent.ShowSnackBar("Titulo não pode ser vazio! "))
                return@launch
            }
        }
    }
}