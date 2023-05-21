package com.example.snackbarcomposedemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.snackbarcomposedemo.ui.theme.SnackBarComposeDemoTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnackBarComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DisplaySnackBar()
                }
            }
        }
    }
}

@Composable
fun DisplaySnackBar() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {
        // For some reason, compiler is pointing error for not user shadowed parameter it
        // val padding = it
        Button(
            onClick = {
                coroutineScope.launch {
                    val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                        message = "This is the message",
                        actionLabel = "Undo",
                        duration = SnackbarDuration.Long
                    )
                    when (snackBarResult) {
                        SnackbarResult.ActionPerformed -> Log.i("MyTag", "action label clicked")
                        SnackbarResult.Dismissed -> Log.i("MyTag", "dismissed")
                    }
                }
            },
            modifier = Modifier.padding(it)
        ) {
            Text(text = "Display Snackbar")
        }
    }
}
