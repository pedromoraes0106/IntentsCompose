package br.edu.ifsp.scl.sc304775x.intentscompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.edu.ifsp.scl.sc304775x.intentscompose.MainViewModel
import br.edu.ifsp.scl.sc304775x.intentscompose.ui.composable.screen.HomeScreen
import br.edu.ifsp.scl.sc304775x.intentscompose.ui.composable.screen.AddWordScreen

@Composable
fun MainNavHost(
    navHostController: NavHostController,
    modifier: Modifier,
    mainViewModel: MainViewModel
) {
    val parameter by mainViewModel.parameterState.collectAsStateWithLifecycle()

    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                receivedParameter = parameter,
                modifier = modifier,
                onAddWord = {
                    navHostController.navigate(Screen.AddWordScreeen.route)
                }
            )
        }
        composable(route = Screen.AddWordScreeen.route) {
            AddWordScreen(
                receivedParameter = parameter,
                modifier = modifier,
                onSave = mainViewModel::updateParameter
            ) {
                navHostController.popBackStack()
            }
        }
    }
}