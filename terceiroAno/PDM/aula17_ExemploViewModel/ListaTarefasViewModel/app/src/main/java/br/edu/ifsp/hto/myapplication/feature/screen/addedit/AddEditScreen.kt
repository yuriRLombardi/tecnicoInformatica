package br.edu.ifsp.hto.myapplication.feature.screen.addedit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import br.edu.ifsp.hto.myapplication.data.TaskDAO
import br.edu.ifsp.hto.myapplication.data.TaskDatabaseProvider
import br.edu.ifsp.hto.myapplication.data.TaskRepositoryImpl
import br.edu.ifsp.hto.myapplication.domain.task1
import br.edu.ifsp.hto.myapplication.domain.task2
import br.edu.ifsp.hto.myapplication.feature.screen.UIEvent
import kotlinx.coroutines.launch

// TODO(29) Esta tela permite tanto a adição de um novo item quanto a edição. Por isso ele pode
//  receber como argumento um taskId. Caso ele seja nulo, isso indica que é uma adição, caso seja
//  diferente de nulo trata-se de uma edição de uma tarefa existente.
@Composable
fun AddEditScreen(
    taskId: Long?,
    onBack: () -> Unit
) {
    // TODO(31) Recuperamos o contexto da aplicação, necessário para o Banco de Dados.
    val context = LocalContext.current.applicationContext

    // TODO(32) Criamos o TaskDatabaseProvider para ter acesso ao Banco de Dados.
    val database = TaskDatabaseProvider.provide(
        context = context
    )

    // TODO(33): Criar o repositório, que precisará do taskDAO para interagir com o banco de dados
    val taskRepository = TaskRepositoryImpl(
        dao = database.taskDAO()
    )

    val  viewModel = viewModel<AddEditViewModel>{
        AddEditViewModel(
            id = taskId,
            taskRepository = taskRepository
        )
    }

    var title = viewModel.title
    var description = viewModel.description

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect{ uiEvent: UIEvent ->
            when(uiEvent){
                is UIEvent.Navigate<*> -> {

                }
                UIEvent.NavigateBack -> {
                    onBack()
                }
                is UIEvent.ShowSnackBar -> {
                    snackbarHostState.showSnackbar(
                        message = uiEvent.message
                    )
                }
            }
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // TODO(39) Ao clicar no floatingButton a função onEvent é chamada idicando o
                    //  evento AddEditEvent.Save.
                    viewModel.onEvent(AddEditEvent.Save)

                }
            ) {
                Icon(
                    Icons.Default.Done,
                    contentDescription = ""
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .consumeWindowInsets(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = {
                    viewModel.onEvent(
                        AddEditEvent.TitleChanged(it)
                    )
                },
                label = {
                    Text("Título")
                }
            )
            OutlinedTextField(
                value = description ?: "",
                onValueChange = {
                    viewModel.onEvent(
                      AddEditEvent.DescriptionChanged(it)
                    )
                },
                label = {
                    Text("Descrição")
                }
            )
        }
    }
}

@Preview
@Composable
private fun AddEditScreenNoTaskPreview() {
    AddEditScreen(
        taskId = null,
        onBack = {}
    )
}

@Preview
@Composable
private fun AddEditScreenWithTaskPreview() {

    AddEditScreen(
        taskId = task2.id,
        onBack = {}
    )
}