package com.example.unitconverter.presentation.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unitconverter.data.model.Conversion
import com.example.unitconverter.presentation.ui.viewmodel.ConverterViewModel

@Composable
fun TopScreen(list: List<Conversion>, saveAction: (String, String) -> Unit) {
    val selectedConversion: MutableState<Conversion?> = remember { mutableStateOf(null) }
    val inputText: MutableState<String> = remember { mutableStateOf("") }
    val typedValue = remember { mutableStateOf("0.0") }

    ConversionMenu(list = list) {
        selectedConversion.value = it
        typedValue.value = "0.0"
    }

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText) { input ->
            typedValue.value = input
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
        saveAction(message1, message2)
        ResultBlock(message1 = message1, message2 = message2)
    }
}

@Preview(showBackground = true)
@Composable
fun TopScreenPreview() {
    TopScreen(
        listOf(
            Conversion(
                0,
                "example",
                "id",
                "example",
                30.00
            )
        )
    ) { message1, message2 -> }
}