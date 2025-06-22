package br.edu.ifsp.listatarefa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.listatarefa.data.TaskDAOImpl
import br.edu.ifsp.listatarefa.domain.task1
import br.edu.ifsp.listatarefa.domain.task2
import br.edu.ifsp.listatarefa.domain.task3
import br.edu.ifsp.listatarefa.feature.screnn.ListScreen
import br.edu.ifsp.listatarefa.navigator.TaskNavHost
import br.edu.ifsp.listatarefa.ui.theme.ListaTarefaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaTarefaTheme {
                Box(
                    modifier = Modifier
                        .safeDrawingPadding()
                ) {
                    TaskNavHost()
                }
            }
        }
    }
}

