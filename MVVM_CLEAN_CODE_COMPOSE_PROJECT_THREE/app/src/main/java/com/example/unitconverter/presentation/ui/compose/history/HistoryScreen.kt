package com.example.unitconverter.presentation.ui.compose.history

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.example.unitconverter.data.model.ConversionResult

@Composable
fun HistoryScreen(list: State<List<ConversionResult>>, onCloseTask: (ConversionResult) -> Unit) {
    HistoryList(list = list, onCloseTask = { onCloseTask.invoke(it) })
}