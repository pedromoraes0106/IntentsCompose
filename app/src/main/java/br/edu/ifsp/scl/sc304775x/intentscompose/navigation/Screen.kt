package br.edu.ifsp.scl.sc304775x.intentscompose.navigation

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object AddWordScreeen: Screen("add_screen")
}