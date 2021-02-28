import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import okhttp3.OkHttpClient
import okhttp3.Request

fun main() = Window {

    MaterialTheme {
        Column {
            NetworkButton()
            Spacer(modifier = Modifier.height(10.dp))
            DialogButton()
        }
    }
}

@Composable
fun DialogButton() {
    var shouldShowDialog by remember { mutableStateOf(false) }
    Button(
        onClick = {
            shouldShowDialog = true
        }
    ) {
        Text(text = "SHOW DIALOG")
    }

    if (shouldShowDialog) {

        Dialog(
            onDismissRequest = {
                shouldShowDialog = false
            }
        ) {
            Text(text = "Sample content")
        }
    }
}

@Composable
fun NetworkButton() {
    Button(onClick = {
        // Do network call
        doNetworkCall()

    }) {
        Text(text = "Make Network Call")
    }
}

fun doNetworkCall() {
    with(OkHttpClient()) {

        Request.Builder()
            .url("https://raw.githubusercontent.com/theapache64/stackzy/master/gpm.json")
            .build()
            .let { request ->
                println("Resp : ${newCall(request).execute().body?.string()}")
            }

    }
}
