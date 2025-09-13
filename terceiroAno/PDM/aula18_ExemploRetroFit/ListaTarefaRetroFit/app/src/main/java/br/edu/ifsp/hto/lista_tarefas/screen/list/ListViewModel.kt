package br.edu.ifsp.hto.lista_tarefas.screen.list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.ifsp.hto.lista_tarefas.data.TaskRepository
import br.edu.ifsp.hto.lista_tarefas.domain.Task
import br.edu.ifsp.hto.lista_tarefas.screen.UIEvent
import br.edu.ifsp.hto.listatarefas.navigation.AddEditScreenRoute
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class ListViewModel(
    private val taskRepository: TaskRepository
) : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    //mudança de fluxo para estado
    /*
    val tasks = taskRepository.getAll()
        .stateIn(
            scope = viewModelScope,
            // guarda dados por 5 segundos
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    */
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        fetchTasks()
    }

    fun fetchTasks(){
        viewModelScope.launch {
            taskRepository.getAll()
                .collect{ list ->
                    _tasks.value = list
                }
        }
    }

    fun onEvent(event: ListEvent) {
        when (event) {
            is ListEvent.Delete -> {
                delete(
                    id = event.id
                )
            }

            is ListEvent.IsFinishedChanged -> {
                isFinishedChanged(
                    id = event.id,
                    isFinished = event.isFinished
                )
            }

            is ListEvent.AddEdit -> {
                viewModelScope.launch {
                    _uiEvent.send(UIEvent.Navigate(AddEditScreenRoute(event.id)))
                }
            }
        }
    }

    private fun delete(id: Long) {
        viewModelScope.launch {
            taskRepository.delete(id)
            fetchTasks()
        }
    }

    private fun isFinishedChanged(id: Long, isFinished: Boolean) {
        viewModelScope.launch {
            taskRepository.updateIsFinished(
                id = id,
                isFinished = isFinished
            )
            fetchTasks()
        }
    }
}