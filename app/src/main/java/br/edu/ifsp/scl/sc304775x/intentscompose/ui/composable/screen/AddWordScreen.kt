package br.edu.ifsp.scl.sc304775x.intentscompose.ui.composable.screen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.scl.sc304775x.intentscompose.ui.theme.NavigationIntentTheme
import androidx.compose.material3.Surface

@Composable
fun AddWordScreen(
    receivedParameter: String,
    modifier: Modifier,
    onSave: (String) -> Unit,
    onQuit: () -> Unit
) {
    var parameterReceived by remember { mutableStateOf(receivedParameter) }
    var parameter by remember { mutableStateOf("") }
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = "Valor recebido: $parameterReceived")

        OutlinedTextField(
            value = parameter,
            label = { Text("Palavra para concatenar") },
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { parameter = it }
        )
        Button(
            onClick = {
                onSave(parameter)
                onQuit()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Concatenar")
        }
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun AddWordScreenPreview() {
    NavigationIntentTheme {
        Surface {
            AddWordScreen(
                receivedParameter = "",
                modifier = Modifier,
                onSave = { }
            ) { }
        }
    }
}