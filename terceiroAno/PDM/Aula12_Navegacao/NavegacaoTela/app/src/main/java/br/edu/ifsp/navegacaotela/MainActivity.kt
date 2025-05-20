package br.edu.ifsp.navegacaotela

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.navegacaotela.navigation.NavigationNavHost
import br.edu.ifsp.navegacaotela.ui.theme.NavegacaoTelaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacaoTelaTheme {
                Box(
                    modifier = Modifier
                        .safeDrawingPadding()
                ) {
                    NavigationNavHost()
                }

            }
        }
    }
}
