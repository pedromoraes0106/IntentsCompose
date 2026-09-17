package br.edu.ifsp.scl.sc304775x.intentscompose.ui.composable.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController,
    onAddWord: (String) -> Unit
) {
    var accumulatedString by rememberSaveable { mutableStateOf("") }
    val savedStateHandle = navController.currentBackStackEntry?.savedStateHandle
    val newWord = savedStateHandle?.remove<String>("newWord") ?: ""

    if (newWord.isNotEmpty()) {
        accumulatedString = if (accumulatedString.isEmpty()) {
            newWord
        } else {
            "$accumulatedString $newWord"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = accumulatedString,
            onValueChange = {},
            readOnly = true,
            label = { Text("String Atual") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                onAddWord(accumulatedString)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Adicionar palavra")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                accumulatedString = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reiniciar")
        }
    }
}
