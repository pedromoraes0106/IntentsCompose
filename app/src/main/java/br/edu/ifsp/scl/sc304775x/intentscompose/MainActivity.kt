package br.edu.ifsp.scl.sc304775x.intentscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import br.edu.ifsp.scl.sc304775x.intentscompose.navigation.MainNavHost
import br.edu.ifsp.scl.sc304775x.intentscompose.ui.composable.component.MainTopAppBar
import br.edu.ifsp.scl.sc304775x.intentscompose.ui.theme.NavigationIntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()

            NavigationIntentTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        MainTopAppBar(showActions = true) { destination ->
                            navHostController.navigate(destination)
                        }
                    }
                ) { innerPadding ->
                    MainNavHost(
                        navHostController = navHostController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
