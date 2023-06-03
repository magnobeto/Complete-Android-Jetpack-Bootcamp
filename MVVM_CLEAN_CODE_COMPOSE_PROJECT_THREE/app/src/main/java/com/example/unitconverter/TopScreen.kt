package com.example.unitconverter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun TopScreen(list: List<Conversion>) {

    val selectedConversion = remember { mutableStateOf<Conversion?>(null) }
    val inputText = remember { mutableStateOf("") }

    ConversionMenu(list = list) { conversion ->
        selectedConversion.value = conversion
    }

    selectedConversion.value?.let { conversion ->
        InputBlock(conversion = conversion, inputText = inputText)
    }
}