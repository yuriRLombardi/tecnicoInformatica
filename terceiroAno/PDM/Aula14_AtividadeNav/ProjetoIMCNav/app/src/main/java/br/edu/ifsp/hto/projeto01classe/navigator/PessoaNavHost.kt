package br.edu.ifsp.hto.projeto01classe.navigator

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import br.edu.ifsp.hto.projeto01classe.data.PessoaDAO
import br.edu.ifsp.hto.projeto01classe.data.PessoaDAOImpli
import br.edu.ifsp.hto.projeto01classe.feature.screen.AddEditPessoa
import br.edu.ifsp.hto.projeto01classe.feature.screen.ListScreen
import kotlinx.serialization.Serializable

@Serializable
object ListScreenRoute

@Serializable
data class AddEditPessoaRoute(val id: Long?)

@Composable
fun PessoaNavHost() {
    val navController = rememberNavController()
    val pessoaDAO: PessoaDAO = PessoaDAOImpli()
    NavHost(navController = navController, startDestination = ListScreenRoute) {
        composable<ListScreenRoute> {
            ListScreen(
                pessoaDAO = pessoaDAO,
                navigationAddEditPessoa = { id ->
                    navController.navigate(AddEditPessoaRoute(id = id))
                }
            )
        }
        composable<AddEditPessoaRoute> { navBackStackEntry ->
            val addEditPessoaRoute = navBackStackEntry.toRoute<AddEditPessoaRoute>()
            AddEditPessoa(
                pessoaDAOImpli = pessoaDAO,
                pessoaID = addEditPessoaRoute.id,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}