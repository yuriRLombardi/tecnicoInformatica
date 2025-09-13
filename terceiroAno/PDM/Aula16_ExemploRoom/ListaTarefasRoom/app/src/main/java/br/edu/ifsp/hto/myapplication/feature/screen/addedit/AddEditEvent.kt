package br.edu.ifsp.hto.myapplication.feature.screen.addedit

sealed interface AddEditEvent {
    data object Save : AddEditEvent
}