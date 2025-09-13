package br.edu.ifsp.hto.lista_tarefas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import br.edu.ifsp.hto.lista_tarefas.ui.theme.Programa07_03_lista_tarefasTheme
import br.edu.ifsp.hto.listatarefas.navigation.TaskNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Box(
                modifier = Modifier
                    .safeDrawingPadding()
            ) {
                Programa07_03_lista_tarefasTheme {
                    TaskNavHost()
                }
            }
        }
    }
}