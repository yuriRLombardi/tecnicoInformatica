package br.edu.ifsp.hto.projeto01classe.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import br.edu.ifsp.hto.projeto01classe.feature.screen.addedit.AddEditPessoa
import br.edu.ifsp.hto.projeto01classe.feature.screen.list.ListScreen
import kotlinx.serialization.Serializable

@Serializable
object ListScreenRoute

@Serializable
data class AddEditPessoaRoute(val id: Long?)

@Composable
fun PessoaNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ListScreenRoute) {
        composable<ListScreenRoute> {
            ListScreen(
                navigationAddEditPessoa = { id ->
                    navController.navigate(AddEditPessoaRoute(id = id))
                }
            )
        }
        composable<AddEditPessoaRoute> { navBackStackEntry ->
            val addEditPessoaRoute = navBackStackEntry.toRoute<AddEditPessoaRoute>()
            AddEditPessoa(
                pessoaID = addEditPessoaRoute.id,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}