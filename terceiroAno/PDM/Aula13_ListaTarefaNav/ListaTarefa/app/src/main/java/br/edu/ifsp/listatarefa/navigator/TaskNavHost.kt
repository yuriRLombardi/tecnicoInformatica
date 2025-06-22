package br.edu.ifsp.listatarefa.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import br.edu.ifsp.listatarefa.data.TaskDAO
import br.edu.ifsp.listatarefa.data.TaskDAOImpl
import br.edu.ifsp.listatarefa.feature.screnn.AddEditScreen
import br.edu.ifsp.listatarefa.feature.screnn.ListScreen
import kotlinx.serialization.Serializable

@Serializable
object ListScreenRoute

@Serializable
data class AddEditScreenRoute(val id: Long?)

@Composable
fun TaskNavHost() {
    val navController = rememberNavController()
    val taskDAO: TaskDAO = TaskDAOImpl()

    NavHost(navController = navController, startDestination = ListScreenRoute) {

        composable<ListScreenRoute> {
            ListScreen(
                taskDAO = taskDAO,
                navigateToAddEditScreen = { id ->
                    navController.navigate(AddEditScreenRoute(id = id))
                }
            )
        }

        composable<AddEditScreenRoute> { navBackStackEntry ->
            val addEditScreenRoute = navBackStackEntry.toRoute<AddEditScreenRoute>()

            AddEditScreen(
                taskDAOImpl = taskDAO,
                taskId = addEditScreenRoute.id,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}




