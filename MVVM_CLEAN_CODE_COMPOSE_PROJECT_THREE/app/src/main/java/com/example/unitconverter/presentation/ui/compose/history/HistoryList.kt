package com.example.unitconverter.presentation.ui.compose.history

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unitconverter.data.model.ConversionResult

@Composable
fun HistoryList(
    list: State<List<ConversionResult>>,
    onCloseTask: (ConversionResult) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(items = list.value, key = { item -> item.id }) { item ->
            HistoryItem(messagePart1 = item.messagePart1,
                messagePart2 = item.messagePart2,
                onClose = { onCloseTask(item) })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HistoryListPreview() {
    val state = remember {
        mutableStateOf(
            listOf(
                ConversionResult(0, "example", "example"),
                ConversionResult(1, "example", "example"),
                ConversionResult(2, "example", "example")
            )
        )
    }
    HistoryList(list = state, onCloseTask = {})
}