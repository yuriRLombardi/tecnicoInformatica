package br.edu.ifsp.hto.listatarefas.feature.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.edu.ifsp.hto.lista_tarefas.data.TaskRepositoryImpl
import br.edu.ifsp.hto.lista_tarefas.screen.UIEvent
import br.edu.ifsp.hto.lista_tarefas.screen.addedit.AddEditEvent
import br.edu.ifsp.hto.lista_tarefas.screen.addedit.AddEditViewModel
import br.edu.ifsp.hto.lista_tarefas.ui.theme.Programa07_03_lista_tarefasTheme

@Composable
fun AddEditScreen(
    id: Long?,
    navigateBack: () -> Unit
) {

    val repository = TaskRepositoryImpl()

    val viewModel = viewModel<AddEditViewModel>() {
        AddEditViewModel(
            taskRepository = repository,
            id = id,
        )
    }

    var title = viewModel.title
    var description = viewModel.description

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { uiEvent ->
            when (uiEvent) {
                is UIEvent.ShowSnackBar -> {
                    snackbarHostState.showSnackbar(
                        message = uiEvent.message
                    )
                }

                is UIEvent.Navigate<*> -> {

                }

                UIEvent.NavigateBack -> {
                    navigateBack()
                }
            }
        }
    }

    AddEditContent(
        id = id,
        title = title,
        description = description,
        onEvent = viewModel::onEvent,
        snackbarHostState = snackbarHostState,
    )
}

@Composable
fun AddEditContent(
    id: Long?,
    title: String,
    description: String?,
    onEvent: (AddEditEvent) -> Unit,
    snackbarHostState: SnackbarHostState
) {
    Scaffold(
        topBar = {
            Text(
                if (id != null) "Editar Tarefa" else "Adicionar Tarefa",
                style = TextStyle(
                    fontSize = 32.sp
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEvent(AddEditEvent.Save)
                }
            ) {
                Icon(Icons.Default.Check, contentDescription = "Salvar")
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .consumeWindowInsets(paddingValues)
                .padding(paddingValues)
        ) {

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = title,
                onValueChange = {
                    onEvent(
                        AddEditEvent.TitleChanged(it)
                    )
                },
                label = { Text("Título") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = description ?: "",
                onValueChange = {
                    onEvent(
                        AddEditEvent.DescriptionChanged(it)
                    )
                },
                label = { Text("Descrição") }
            )
        }
    }
}

@Preview
@Composable
private fun EditScreenPreview() {

    Programa07_03_lista_tarefasTheme {
        AddEditScreen(
            id = 1,
            navigateBack = {}
        )
    }
}

@Preview
@Composable
private fun AddScreenPreview() {
    Programa07_03_lista_tarefasTheme {
        AddEditScreen(
            id = null,
            navigateBack = {}
        )
    }
}