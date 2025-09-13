package br.edu.ifsp.hto.myapplication.feature.screen


sealed interface UIEvent {
    data class  ShowSnackBar(val message: String) : UIEvent

    data object NavigateBack : UIEvent

    data class Navigate<T : Any>(val route: T): UIEvent
}