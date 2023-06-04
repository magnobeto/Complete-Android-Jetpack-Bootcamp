package com.example.unitconverter.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unitconverter.presentation.ui.compose.converter.TopScreen
import com.example.unitconverter.presentation.ui.compose.history.HistoryScreen
import com.example.unitconverter.presentation.ui.viewmodel.ConverterViewModel

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel()
) {
    val list = converterViewModel.getConversions()
    val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())

    Column(modifier = modifier.padding(30.dp)) {
        TopScreen(
            list,
            converterViewModel.selectedConversion,
            converterViewModel.inputText,
            converterViewModel.typedValue
        ) { message1, message2 ->
            converterViewModel.addResult(message1, message2)
        }
        Spacer(modifier = modifier.height(20.dp))
        HistoryScreen(
            historyList,
            { conversionResult -> converterViewModel.deleteResult(conversionResult) },
            { converterViewModel.deleteAllResults() }
        )
    }
}