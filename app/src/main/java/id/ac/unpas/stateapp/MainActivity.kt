package id.ac.unpas.stateapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.ac.unpas.stateapp.ui.theme.StateAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var name by rememberSaveable { mutableStateOf("") }
    val scaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    )
    
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar() {
                Text("State App")
            }
        },
        drawerContent = {
            Text(text = "Drawer Content")
        }
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            OutlinedTextField(value = name, onValueChange = {
                name = it
            })
            Text(text = "Hello $name")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StateAppTheme {
        Greeting()
    }
}