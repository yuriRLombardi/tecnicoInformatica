package br.edu.ifsp.navegacaotela.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import br.edu.ifsp.navegacaotela.feature.screen.SecondScreen
import br.edu.ifsp.navegacaotela.feature.screen.StartScreen
import kotlinx.serialization.Serializable

@Serializable
object StartScreenRoute

@Serializable
data class SecondScreenRoute(val message: String?)

@Composable
fun NavigationNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = StartScreenRoute){
        composable<StartScreenRoute> {
            StartScreen(
                navigationSecondScreen = { message ->
                    navController.navigate(
                        SecondScreenRoute(
                            message = message
                        )
                    )
                }
            )
        }
        composable<SecondScreenRoute> {navBackStackEntry ->
            val secondScreenRoute = navBackStackEntry.toRoute<SecondScreenRoute>()
            SecondScreen(
                message = secondScreenRoute.message,
                onBack = {navController.popBackStack()}
            )
        }
    }
}

