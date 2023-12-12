package com.example.a01_status

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a01_status.ui.theme._01_StatusTheme
import android.util.Log
import android.widget.Toast

class MainActivity : ComponentActivity() {
    val TAG = "Estados"
    override fun onCreate(savedInstanceState: Bundle?) {
        //Call logCat
        Log.i(TAG, "Método onCreate()")
        Toast.makeText(this,"Método onCreate()",Toast.LENGTH_SHORT).show()
        super.onCreate(savedInstanceState)
        setContent {
            _01_StatusTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _01_StatusTheme {
        Greeting("Android")
    }
}