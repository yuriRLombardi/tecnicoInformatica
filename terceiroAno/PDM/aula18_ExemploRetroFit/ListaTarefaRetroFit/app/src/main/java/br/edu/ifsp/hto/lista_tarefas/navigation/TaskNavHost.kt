package br.edu.ifsp.hto.listatarefas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import br.edu.ifsp.hto.listatarefas.feature.screen.AddEditScreen
import br.edu.ifsp.hto.listatarefas.feature.screen.ListScreen
import kotlinx.serialization.Serializable

@Serializable
object ListScreenRoute

@Serializable
data class AddEditScreenRoute(val id: Long? = null)

@Composable
fun TaskNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ListScreenRoute) {
        composable<ListScreenRoute> {
            ListScreen(
                navigateToAddEditScreen = { id ->
                    navController.navigate(AddEditScreenRoute(id = id))
                }
            )
        }

        composable<AddEditScreenRoute> { navBackStackEntry ->
            val addEditScreenRoute = navBackStackEntry.toRoute<AddEditScreenRoute>()

            AddEditScreen(
                id = addEditScreenRoute.id,
                navigateBack = {
                    navController.popBackStack()
                },
            )
        }
    }
}