package com.example.unitconverter

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel()
) {
    val list = converterViewModel.getConversions()
}