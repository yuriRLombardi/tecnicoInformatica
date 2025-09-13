package br.edu.ifsp.hto.projeto01classe.feature.screen.addedit

sealed interface AddEditEvent {
    data object Save : AddEditEvent
}