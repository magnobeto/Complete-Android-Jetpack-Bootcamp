package com.example.unitconverter

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun TopScreen(list: List<Conversion>) {

    val context = LocalContext.current
    val selectedConversion = remember { mutableStateOf<Conversion?>(null) }
    val inputText = remember { mutableStateOf("") }

    ConversionMenu(list = list) { conversion ->
        selectedConversion.value = conversion
    }

    selectedConversion.value?.let { conversion ->
        InputBlock(conversion = conversion, inputText = inputText) { inputText ->
            Toast.makeText(context, "Work! $inputText", Toast.LENGTH_LONG).show()
        }
    }
}