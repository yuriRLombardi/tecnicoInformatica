package br.edu.ifsp.hto.listatarefas.feature.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.edu.ifsp.hto.lista_tarefas.data.TaskRepositoryImpl
import br.edu.ifsp.hto.lista_tarefas.domain.Task
import br.edu.ifsp.hto.lista_tarefas.domain.task1
import br.edu.ifsp.hto.lista_tarefas.domain.task2
import br.edu.ifsp.hto.lista_tarefas.domain.task3
import br.edu.ifsp.hto.lista_tarefas.screen.UIEvent
import br.edu.ifsp.hto.lista_tarefas.screen.list.ListEvent
import br.edu.ifsp.hto.lista_tarefas.screen.list.ListViewModel
import br.edu.ifsp.hto.lista_tarefas.ui.theme.Programa07_03_lista_tarefasTheme
import br.edu.ifsp.hto.listatarefas.navigation.AddEditScreenRoute


@Composable
fun ListScreen(
    navigateToAddEditScreen: (id: Long?) -> Unit,
) {
    val repository = TaskRepositoryImpl()

    val viewModel = viewModel<ListViewModel>() {
        ListViewModel(
            taskRepository = repository
        )
    }

    val tasks by viewModel.tasks.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchTasks()
    }

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { uiEvent ->
            when (uiEvent) {
                is UIEvent.Navigate<*> -> {
                    when (uiEvent.route) {
                        is AddEditScreenRoute -> {
                            navigateToAddEditScreen(uiEvent.route.id)
                        }
                    }
                }

                is UIEvent.ShowSnackBar -> {

                }

                UIEvent.NavigateBack -> {

                }
            }
        }
    }

    ListScreenContent(
        tasks = tasks,
        onEvent = viewModel::onEvent,
    )
}

@Composable
fun ListScreenContent(
    tasks: List<Task>,
    onEvent: (ListEvent) -> Unit
) {
    Scaffold(
        topBar = {
            Text(
                "Lista de Tarefas",
                style = TextStyle(
                    fontSize = 32.sp
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEvent(ListEvent.AddEdit(null))
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.consumeWindowInsets(paddingValues),
            contentPadding = paddingValues
        ) {
            itemsIndexed(tasks) { index, task ->
                TaskCard(
                    task = task,
                    onEvent = onEvent,
                )

                if (index < tasks.lastIndex) {
                    Spacer(
                        modifier = Modifier
                            .height(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun TaskCard(
    task: Task,
    onEvent: (ListEvent) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Checkbox(
                checked = task.isFinished,
                onCheckedChange = { newValue ->
                    onEvent(
                        ListEvent.IsFinishedChanged(
                            id = task.id,
                            isFinished = newValue
                        )
                    )
                }
            )
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleLarge
                )

                task.description?.let {
                    Text(
                        text = task.description,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            Button(
                onClick = {
                    onEvent(
                        ListEvent.AddEdit(
                            id = task.id
                        )
                    )
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Editar",
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    onEvent(
                        ListEvent.Delete(
                            id = task.id
                        )
                    )
                },
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Remover",
                )
            }
        }
    }
}

@Preview
@Composable
private fun ListScreenContentPreview() {
    Programa07_03_lista_tarefasTheme {
        ListScreenContent(
            tasks = listOf(
                task1,
                task2,
                task3,
            ),
            onEvent = {}
        )
    }
}