package br.edu.ifsp.hto.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import br.edu.ifsp.hto.myapplication.navigation.TaskNavHost
import br.edu.ifsp.hto.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                Box(
                    modifier = Modifier
                        .safeDrawingPadding()
                ) {
                    // TODO(31) Chamamos o TaskNavHost ao invés de um composable de tela.
                    TaskNavHost()
                }
            }
        }
    }
}