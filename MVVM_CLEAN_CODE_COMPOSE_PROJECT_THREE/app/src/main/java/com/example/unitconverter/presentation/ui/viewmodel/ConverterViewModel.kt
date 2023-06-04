package com.example.unitconverter.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unitconverter.data.model.Conversion
import com.example.unitconverter.data.model.ConversionResult
import com.example.unitconverter.data.repository.ConverterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val converterRepository: ConverterRepository
) : ViewModel() {

    fun getConversions() = listOf(
        Conversion(
            1,
            "Pounds to Kilograms",
            "lbs",
            "kg",
            0.453592
        ),
        Conversion(
            2,
            "Kilograms to Pounds",
            "kg",
            "lbs",
            2.20462
        ),
        Conversion(3, "Yards to Meters", "yd", "m", 0.9144),
        Conversion(4, "Meters to Yards", "m", "yd", 1.09361),
        Conversion(5, "Miles to Kilometers", "mi", "km", 1.60934),
        Conversion(6, "Kilometers to Miles", "km", "mi", 0.621371)
    )

    fun addResult(message1: String, message2: String) = viewModelScope.launch(Dispatchers.IO) {
        converterRepository.insertResult(ConversionResult(0, message1, message2))
    }
}