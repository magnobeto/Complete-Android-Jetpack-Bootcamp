package com.anushka.livedatademo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivityViewModel(startingValue: Int): ViewModel() {

    private var _totalSum = MutableStateFlow<Int>(0)
    val totalSum = _totalSum

    init {
        _totalSum.value = startingValue
    }

    fun sumNumberInput(number: Int) {
        _totalSum.value = _totalSum.value.plus(number)
    }
}