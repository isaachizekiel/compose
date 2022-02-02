package com.izak.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.izak.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp(names: List<String> = listOf("World", "compose")) {
    Column (modifier = Modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name =  name)
        }
    }
}


@Composable
fun Greeting(name: String) {
    // Surface and MaterialTheme are concepts related to Material Design
    // the component nested inside Surface will be drawn on top of the background color.
    Surface(
        color = MaterialTheme.colors.primary,
        modifier  = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        // to add multiple modifiers we just chain them
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Hello, ")
                Text(text = name)
            }

            OutlinedButton(onClick = { /*TODO*/ }) {
                Text ("Show More")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    // Depends On How the Project is named in this case it is compose
    ComposeTheme {
        Greeting("Android")
    }
}