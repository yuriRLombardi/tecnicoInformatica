package br.edu.ifsp.calculadoranavegacao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.calculadoranavegacao.navigation.NavigationNavHost
import br.edu.ifsp.calculadoranavegacao.ui.theme.CalculadoraNavegacaoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraNavegacaoTheme {
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

