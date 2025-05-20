package br.edu.ifsp.calculadoranavegacao.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import br.edu.ifsp.calculadoranavegacao.feature.screen.TelaOperacoes
import br.edu.ifsp.calculadoranavegacao.feature.screen.TelaValores
import kotlinx.serialization.Serializable

@Serializable
object TelaValoresRoute

@Serializable
data class TelaOperacoesRoute(val num1:Float,val num2:Float)

@Composable
fun NavigationNavHost() {
    val navigatorController = rememberNavController()
    NavHost(navController = navigatorController, startDestination = TelaValoresRoute){
        composable<TelaValoresRoute> {
            TelaValores {
                num1: Float, num2: Float ->
                navigatorController.navigate(
                    TelaOperacoesRoute(
                        num1 = num1,
                        num2 = num2
                    )
                )
            }
        }
        composable<TelaOperacoesRoute> { navBackStackEntry ->
            val telaOperacoesRoute = navBackStackEntry.toRoute<TelaOperacoesRoute>()
            TelaOperacoes(
                num1 = telaOperacoesRoute.num1,
                num2 = telaOperacoesRoute.num2,
                onBack = {
                    navigatorController.popBackStack()
                }
            )
        }
    }
}