package br.edu.ifsp.hto.myapplication.feature.screen.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import br.edu.ifsp.hto.myapplication.data.TaskRepository
import br.edu.ifsp.hto.myapplication.feature.screen.UIEvent
import br.edu.ifsp.hto.myapplication.navigation.AddEditScreenRoute
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ListViewModel(
    val taskRepository: TaskRepository
) : ViewModel() {

    val task = taskRepository.getAll().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    private val _uiEventet = Channel<UIEvent>()
    val uiEvent = _uiEventet.receiveAsFlow()

    fun onEvent(event: ListEvent) {
        when(event){
            is ListEvent.AddEdit -> {
                viewModelScope.launch {
                    _uiEventet.send(
                        UIEvent.Navigate(
                            AddEditScreenRoute(
                                id = event.id
                            )
                        )
                    )
                }
            }
            is ListEvent.Delete -> {
                delete(
                    id = event.id
                )
            }
            is ListEvent.IsFinishedChanged -> {
                isFinishedChange(
                    id = event.id,
                    isFinished = event.isFinished
                )
            }
        }
    }
    private fun delete(id: Long){
        viewModelScope.launch {
            taskRepository.delete(
                id = id
            )
        }
    }
    private fun isFinishedChange(id: Long,isFinished : Boolean){
        viewModelScope.launch {
            taskRepository.isFinishedChanged(
                id = id,
                isFinished = isFinished
            )
        }
    }
}