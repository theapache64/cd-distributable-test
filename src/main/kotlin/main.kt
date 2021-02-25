import androidx.compose.desktop.Window
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import okhttp3.OkHttpClient
import okhttp3.Request

fun main() = Window {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, Desktop!"

            // Do network call
            doNetworkCall()


        }) {
            Text(text)
        }
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
