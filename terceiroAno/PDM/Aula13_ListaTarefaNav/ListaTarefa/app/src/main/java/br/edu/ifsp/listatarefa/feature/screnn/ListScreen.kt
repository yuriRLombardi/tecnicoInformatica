package br.edu.ifsp.listatarefa.feature.screnn

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.ifsp.listatarefa.data.TaskDAO
import br.edu.ifsp.listatarefa.domain.Task
import br.edu.ifsp.listatarefa.domain.task1
import br.edu.ifsp.listatarefa.domain.task2
import br.edu.ifsp.listatarefa.domain.task3

@Composable
fun ListScreen(
    taskDAO: TaskDAO,
    navigateToAddEditScreen: (id: Long?) -> Unit
) {
    ListScreenContent(
        tasks = taskDAO.getAllTask(),
        navigateToAddEditScreen = navigateToAddEditScreen,
        onDelete = { id ->
            val taskFromList = taskDAO.getTaskByID(id)
            if (taskFromList != null) {
                taskDAO.delete(taskFromList)
            }
        },
        onIsFinishedChange = { task ->
            taskDAO.update(task)
        }
    )
}

@Composable
fun ListScreenContent(
    tasks: List<Task>,
    navigateToAddEditScreen: (id: Long?) -> Unit,
    onDelete: (id: Long) -> Unit,
    onIsFinishedChange: (task: Task) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navigateToAddEditScreen(null)
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
                TaskCard(
                    task = task,
                    navigateToAddEditScreen = navigateToAddEditScreen,
                    onDelete = onDelete,
                    onIsFinishedChange = onIsFinishedChange
                )
            }
        }
    }
}

@Composable
fun TaskCard(
    task: Task,
    navigateToAddEditScreen: (id: Long?) -> Unit,
    onDelete: (id: Long) -> Unit,
    onIsFinishedChange: (task: Task) -> Unit
) {
    var isFinished by remember { mutableStateOf(task.isFinished) }
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
                checked = isFinished,
                onCheckedChange = { newValue ->
                    isFinished = newValue
                    onIsFinishedChange(task.copy(isFinished = isFinished))
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
                    navigateToAddEditScreen(task.id)
                }
            ) {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = "Edit"
                )
            }
            Button(
                onClick = {
                    onDelete(task.id)
                }
            ) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Remove"
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
        navigateToAddEditScreen = {},
        onDelete = {},
        onIsFinishedChange = {}
    )
}