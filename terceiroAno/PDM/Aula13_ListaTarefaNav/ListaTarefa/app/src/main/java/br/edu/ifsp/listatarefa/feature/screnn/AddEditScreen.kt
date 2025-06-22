package br.edu.ifsp.listatarefa.feature.screnn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.listatarefa.data.TaskDAO
import br.edu.ifsp.listatarefa.data.TaskDAOImpl
import br.edu.ifsp.listatarefa.domain.Task
import br.edu.ifsp.listatarefa.domain.task1
import br.edu.ifsp.listatarefa.domain.task2
import br.edu.ifsp.listatarefa.domain.task3

@Composable
fun AddEditScreen(
    taskDAOImpl: TaskDAO,
    taskId: Long?,
    onBack: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var isFinished = false

    if (taskId != null) {
        val taskFromList = taskDAOImpl.getTaskByID(taskId)
        if (taskFromList != null) {
            title = taskFromList.title
            description = taskFromList.description ?: ""
            isFinished = taskFromList.isFinished
        }
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (taskId == null) {
                        val insertTask = Task(
                            id = -1,
                            title = title,
                            description = description,
                            isFinished = false
                        )
                        taskDAOImpl.insert(insertTask)
                    } else {
                        val uptadeTask = Task(
                            id = taskId,
                            title = title,
                            description = description,
                            isFinished = isFinished
                        )
                        taskDAOImpl.update(uptadeTask)
                    }
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
                onValueChange = { title = it },
                label = { Text("Título") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descrição") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
        }
    }

}

@Preview
@Composable
private fun AddEditScreenNoTaskPreview() {
    AddEditScreen(
        taskId = null,
        taskDAOImpl = TaskDAOImpl(),
        onBack = {}
    )
}

@Preview
@Composable
private fun AddEditScreenWitchTaskPreview() {
    val taskDAOImpl = TaskDAOImpl()
    taskDAOImpl.insert(task1)
    taskDAOImpl.insert(task2)

    AddEditScreen(
        taskId = task2.id,
        taskDAOImpl = taskDAOImpl,
        onBack = {}
    )
}


