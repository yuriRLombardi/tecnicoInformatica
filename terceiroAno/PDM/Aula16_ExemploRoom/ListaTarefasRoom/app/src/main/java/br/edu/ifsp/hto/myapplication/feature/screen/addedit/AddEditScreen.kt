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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.enableLiveLiterals
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.hto.myapplication.data.TaskDAO
import br.edu.ifsp.hto.myapplication.data.TaskDatabaseProvider
import br.edu.ifsp.hto.myapplication.data.TaskRepositoryImpl
import br.edu.ifsp.hto.myapplication.domain.task1
import br.edu.ifsp.hto.myapplication.domain.task2
import kotlinx.coroutines.launch

// TODO(20) Esta tela permite tanto a adição de um novo item quanto a edição. Por isso ele pode
//  receber como argumento um taskId. Caso ele seja nulo, isso indica que é uma adição, caso seja
//  diferente de nulo trata-se de uma edição de uma tarefa existente.
@Composable
fun AddEditScreen(
    taskId: Long?,
    onBack: () -> Unit
) {
    // TODO(21) Criamos variáveis para manter o estado dos campos de formulário.
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var isFinished by remember { mutableStateOf(false) }

    val context = LocalContext.current.applicationContext

    val database = TaskDatabaseProvider.provide(
        context = context
    )

    val taskRepository = TaskRepositoryImpl(
        dao = database.taskDAO()
    )

    // TODO(22) Caso seja uma edição, então recuperamos a tarefa da lista, utilizando o dao, de
    //  acordo com o taskId passado como argumento.
    LaunchedEffect(Unit) {
        if (taskId != null) {
            val taskFromDB = taskRepository.getById(taskId)
            if (taskFromDB != null) {
                title = taskFromDB.title
                description = taskFromDB.description ?: ""
                isFinished = taskFromDB.isFinished
            }
        }
    }

    val coroutineScope = rememberCoroutineScope()
    fun onEvent(event: AddEditEvent) {
        when (event) {
            AddEditEvent.Save -> {
                coroutineScope.launch {
                    taskRepository.insert(
                        id = taskId,
                        title = title,
                        description = description
                    )
                }
            }
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEvent(AddEditEvent.Save)
                    onBack()
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
                    title = it
                },
                label = {
                    Text("Título")
                }
            )
            OutlinedTextField(
                value = description,
                onValueChange = {
                    description = it
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