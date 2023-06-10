package com.anushka.effectsdemo1

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anushka.effectsdemo1.ui.theme.EffectsDemo1Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EffectsDemo1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current
) {
    var round by remember { mutableStateOf(1) }
    var total by remember { mutableStateOf(0.0) }
    var input by remember { mutableStateOf("") }

    val scaffoldState : ScaffoldState = rememberScaffoldState()
    val coroutineScope : CoroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {

//   LaunchedEffect(key1 = round ,  ){
//       // Toast.makeText(context,"Please, start counting round $round",Toast.LENGTH_SHORT).show()
//        scaffoldState.snackbarHostState.showSnackbar(
//            message = "Please, start counting round $round",
//            duration = SnackbarDuration.Short
//        )
//   }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = "Total is ${total.toString()}",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.DarkGray
            )
            OutlinedTextField(
                modifier = modifier.fillMaxWidth(),
                placeholder = { Text("Enter value here") },
                value = input,
                onValueChange = {
                    input = it
                },
                textStyle = TextStyle(
                    color = Color.LightGray,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                ),
                label = { Text(text = "New count") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Button(
                modifier = modifier.fillMaxWidth(),
                onClick = {
                    total += input.toDouble()
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            message = "Count updated",
                            duration = SnackbarDuration.Short
                        )
                    }
                    if(total>300){
                        total = 0.0
                        input = ""
                        round++
                    }
                }
            ) {
                Text(
                    text = "Count",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}