package br.edu.ifsp.hto.myapplication.feature.screen.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.edu.ifsp.hto.myapplication.data.TaskDatabaseProvider
import br.edu.ifsp.hto.myapplication.data.TaskRepositoryImpl
import br.edu.ifsp.hto.myapplication.domain.Task
import br.edu.ifsp.hto.myapplication.domain.task1
import br.edu.ifsp.hto.myapplication.domain.task2
import br.edu.ifsp.hto.myapplication.domain.task3
import br.edu.ifsp.hto.myapplication.feature.screen.UIEvent
import br.edu.ifsp.hto.myapplication.feature.screen.addedit.AddEditEvent
import br.edu.ifsp.hto.myapplication.navigation.AddEditScreenRoute
import kotlinx.coroutines.launch

// TODO(42) Na tela de listagem o nosso composable recebe o DAO e uma lambda para que seja possível
//  navegar para a tela que permite adicionar itens à lista. Ao invés de utilizar um composable
//  para tudo definimos o ListScren e o ListScreenContent.
@Composable
fun ListScreen(
    navigateToAddEditScreen: (id: Long?) -> Unit
) {

    // TODO(43) Código necessário para acesso ao Banco de Dados.
    val context = LocalContext.current.applicationContext
    val database = TaskDatabaseProvider.provide(
        context = context
    )
    val taskRepository = TaskRepositoryImpl(
        dao = database.taskDAO()
    )

    val viewModel = viewModel<ListViewModel>{
        ListViewModel(
            taskRepository = taskRepository
        )
    }

    val tasks by viewModel.task.collectAsState()


    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect{ uiEvent : UIEvent ->
            when(uiEvent){
                is UIEvent.Navigate<*> -> {

                    when(uiEvent.route){
                        is AddEditScreenRoute -> {
                            navigateToAddEditScreen(uiEvent.route.id)
                        }
                    }
                }
                UIEvent.NavigateBack -> {

                }
                is UIEvent.ShowSnackBar -> {

                }
            }
        }
    }

    ListScreenContent(
        tasks = tasks,
        onEvent = viewModel :: onEvent
    )
}

// TODO(48) Aqui recebemos a lamba navigateToAddEditScreen, que contém a ação para navegar para a
//  tela de adição. Também há uma lambda que contém a ação de remoção, note que a implementação da
//  remoção está no ListScreen, pois é ele tem acesso ao taskDao.
@Composable
fun ListScreenContent(
    tasks: List<Task>,
    onEvent: (event: ListEvent) -> Unit,
) {
    // TODO(49) Utilizamos o Scaffold, que fornece um layout básico com botão de ação flutuante
    //  (FloatingActionButton),
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // TODO(50) Se estivermos criando uma nova tarefa, então navegamos para a tela
                    //  de edição, mas passando nulo como id.
                    onEvent(
                        ListEvent.AddEdit(
                            id = null
                        )
                    )
                }
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.consumeWindowInsets(paddingValues)
        ) {
            itemsIndexed(tasks) { index, task ->
                // TODO(51) Utilizamos um Card para representar cada item da lista de tarefas. Como
                //  é possível adicionar/editar ou remover um item, são definidas essas duas
                //  lambdas (navigateToAddEditScreen e onDelete).
                TaskCard(
                    task = task,
                    onEvent = onEvent
                )
            }
        }
    }
}

// TODO(52) O TaskCard representa um item da lista.
@Composable
fun TaskCard(
    task: Task,
    onEvent: (event: ListEvent) -> Unit,
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
                // TODO(53) Quando o checkbox é acionado a situação a Task é atualizada.
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
                Text(task.title)
                Text(task.description ?: "")
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
                    Icons.Default.Edit,
                    contentDescription = "Editar"
                )
            }
            Button(
                onClick = {
                    onEvent(
                        ListEvent.Delete(
                            id = task.id
                        )
                    )
                }
            ) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Remover"
                )
            }
        }
    }
}

@Preview
@Composable
private fun ListScreenPreview() {
    ListScreenContent(
        tasks = listOf(
            task1,
            task2,
            task3,
        ),
        onEvent = {}
    )
}