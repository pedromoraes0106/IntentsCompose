package br.edu.ifsp.scl.sc304775x.intentscompose.navigation

sealed class Screen(val route: String) {
    data object HomeScreen : Screen("home_screen")
    data object AddWordScreen : Screen("add_word_screen?currentText={currentText}")
}
