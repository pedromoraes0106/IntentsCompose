package br.edu.ifsp.scl.sc304775x.intentscompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.edu.ifsp.scl.sc304775x.intentscompose.ui.composable.screen.HomeScreen
import br.edu.ifsp.scl.sc304775x.intentscompose.ui.composable.screen.AddWordScreen

@Composable
fun MainNavHost(
    navHostController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route,
        modifier = modifier
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                navController = navHostController,
                onAddWord = { currentText ->
                    navHostController.navigate("add_word_screen?currentText=$currentText")
                }
            )
        }
        composable(
            route = Screen.AddWordScreen.route,
            arguments = listOf(navArgument("currentText") { type = NavType.StringType })
        ) { backStackEntry ->
            val currentText = backStackEntry.arguments?.getString("currentText") ?: ""
            
            AddWordScreen(
                currentText = currentText,
                onConcatenate = { word ->
                    navHostController.previousBackStackEntry
                        ?.savedStateHandle
                        ?.set("newWord", word)
                    navHostController.popBackStack()
                }
            )
        }
    }
}
