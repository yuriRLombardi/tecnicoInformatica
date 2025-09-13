package br.edu.ifsp.hto.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import br.edu.ifsp.hto.myapplication.data.TaskDAO
import br.edu.ifsp.hto.myapplication.feature.screen.addedit.AddEditScreen
import br.edu.ifsp.hto.myapplication.feature.screen.list.ListScreen
import kotlinx.serialization.Serializable

// TODO(24) Definimos um objeto para representar a rota de listagem
@Serializable
object ListScreenRoute

// TODO(24) Definimos uma data class para representar a rota de adição/edição. Note que a rota
//  recebe um argumento id, que pode ser nulo. Novamente, se o id for nulo indica uma adição e se
//  for diferente de nulo representa uam edição.
@Serializable
data class AddEditScreenRoute(val id: Long?)

@Composable
fun TaskNavHost() {
    // TODO(25) Definimos um NavController
    val navController = rememberNavController()
    // TODO(26) Instanciamos o DAO aqui, assim todas as rotas têm acesso ao mesmo DAO.

    NavHost(navController = navController, startDestination = ListScreenRoute) {
        // TODO(27) Definimos uma rota para a listagem. Note que em navigateToAddEditScreen é
        //  implementada a navegação para a tela de edição. Essas lambda (função) é chamada dentro
        //  do ListScreen.
        composable<ListScreenRoute> {
            ListScreen(
                navigateToAddEditScreen = { id ->
                    navController.navigate(AddEditScreenRoute(id = id))
                },
            )
        }

        // TODO(28) Definimos uma rota para a edição.
        composable<AddEditScreenRoute> { navBackStackEntry ->
            // TODO(29) Aqui recuperamos o objeto correspondnete à navegação. Isso permite
            //  verificar, por exemplo, se há algum parâmetro passado pela rota, como é o caso do
            //  id.
            val addEditScreenRoute = navBackStackEntry.toRoute<AddEditScreenRoute>()

            // TODO(30) Chamamos o AddEditScreen, note que o taskId é extraído da rota
            //  addEditScreenRoute.
            AddEditScreen(
                taskId = addEditScreenRoute.id,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}