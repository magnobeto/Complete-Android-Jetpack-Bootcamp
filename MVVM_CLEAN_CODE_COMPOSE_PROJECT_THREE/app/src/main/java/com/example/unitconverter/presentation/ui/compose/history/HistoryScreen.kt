package com.example.unitconverter.presentation.ui.compose.history

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.data.model.ConversionResult

@Composable
fun HistoryScreen(
    list : State<List<ConversionResult>>,
    onCloseTask : (ConversionResult) -> Unit,
    onClearAllTask : () -> Unit,
    modifier: Modifier = Modifier
){
    Column {
        if((list.value).isNotEmpty()) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "History",
                    color = Color.Gray
                )
                OutlinedButton(onClick = { onClearAllTask() }) {
                    Text(
                        text = "Clear All",
                        color = Color.Gray
                    )

                }
            }
        }

        HistoryList(
            list = list,
            onCloseTask = { item ->
                onCloseTask(item)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HistoryScreenPreview() {
    val state = remember {
        mutableStateOf(
            listOf(
                ConversionResult(0, "example", "example"),
                ConversionResult(1, "example", "example"),
                ConversionResult(2, "example", "example")
            )
        )
    }
    HistoryScreen(list = state, onCloseTask = {}, onClearAllTask = {})
}