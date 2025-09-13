package br.edu.ifsp.hto.lista_tarefas.screen.addedit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.ifsp.hto.lista_tarefas.data.TaskRepository
import br.edu.ifsp.hto.lista_tarefas.screen.UIEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AddEditViewModel(
    private val id: Long? = null,
    private val taskRepository: TaskRepository
) : ViewModel() {

    var title by mutableStateOf("")
        private set

    var description by mutableStateOf<String?>(null)
        private set

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        id?.let {
            viewModelScope.launch {
                val task = taskRepository.getById(id)
                title = task?.title ?: ""
                description = task?.description ?: ""
            }
        }
    }

    fun onEvent(event: AddEditEvent) {
        when (event) {
            is AddEditEvent.TitleChanged -> {
                title = event.title
            }

            is AddEditEvent.DescriptionChanged -> {
                description = event.description
            }

            AddEditEvent.Save -> {
                saveTask()
            }
        }
    }

    private fun saveTask() {
        viewModelScope.launch {
            if (title.isBlank()) {
                _uiEvent.send(UIEvent.ShowSnackBar("Título não pode ser vazio"))
                return@launch
            }
            taskRepository.insert(
                title = title,
                description = description,
                id = id,
            )

            _uiEvent.send(UIEvent.NavigateBack)
        }
    }
}