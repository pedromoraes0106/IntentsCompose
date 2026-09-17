package br.edu.ifsp.scl.sc304775x.intentscompose.ui.composable.screen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.scl.sc304775x.intentscompose.ui.theme.NavigationIntentTheme

@Composable
fun HomeScreen(
    receivedParameter: String,
    modifier: Modifier,
    onAddWord: () -> Unit
) {
    val parameter by remember { mutableStateOf(receivedParameter) }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = parameter)

        Button(
            onClick = onAddWord
        ) {
            Text("Adicionar palavra")
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
fun HomeScreenPreview() {
    NavigationIntentTheme {
        Surface {
            HomeScreen(
                receivedParameter = "",
                modifier = Modifier,
                {}
            )
        }
    }
}