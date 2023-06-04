package com.example.unitconverter.presentation.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unitconverter.data.model.Conversion
import com.example.unitconverter.data.model.ConversionResult
import com.example.unitconverter.data.repository.ConverterRepository
import com.example.unitconverter.presentation.ui.utils.conversionsList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val converterRepository: ConverterRepository
) : ViewModel() {

    val resultList = converterRepository.getSavedResults()
    val selectedConversion: MutableState<Conversion?> = mutableStateOf(null)
    val inputText: MutableState<String> = mutableStateOf("")
    val typedValue = mutableStateOf("0.0")

    fun getConversions() = conversionsList()

    fun addResult(message1: String, message2: String) {
        viewModelScope.launch(Dispatchers.IO) {
            converterRepository.insertResult(ConversionResult(0, message1, message2))
        }
    }

    fun deleteResult(result: ConversionResult) {
        viewModelScope.launch(Dispatchers.IO) {
            converterRepository.deleteResult(result)
        }
    }

    fun deleteAllResults() {
        viewModelScope.launch(Dispatchers.IO) {
            converterRepository.deleteAllResults()
        }
    }
}