package com.example.unitconverter.presentation.ui.compose.converter

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.unitconverter.data.model.Conversion

@Composable
fun TopScreen(
    list: List<Conversion>,
    selectedConversion: MutableState<Conversion?>,
    inputText: MutableState<String>,
    typedValue: MutableState<String>,
    saveAction: (String, String) -> Unit
) {

    var toSave by remember { mutableStateOf(false) }

    ConversionMenu(list = list) {
        selectedConversion.value = it
        typedValue.value = "0.0"
    }

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText) { input ->
            typedValue.value = input
            toSave = true
        }
    }

    if (typedValue.value != "0.0") {
        val input = typedValue.value.toDouble()
        val multiply = selectedConversion.value!!.multiplyBy
        val result = input * multiply

//        //rounding off the result to 4 decimal places
//        val df = DecimalFormat("#.####")
//        df.roundingMode = RoundingMode.DOWN
//        val roundedResult = df.format(result)
        val roundedResult = String.format("%.3f", result)

        val message1 = "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equal to"
        val message2 = "$roundedResult ${selectedConversion.value!!.convertTo}"
        if (toSave) {
            saveAction(message1, message2)
            toSave = false
        }
        ResultBlock(message1 = message1, message2 = message2)
    }
}