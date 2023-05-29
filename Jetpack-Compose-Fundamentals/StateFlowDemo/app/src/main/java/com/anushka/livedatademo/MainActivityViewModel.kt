package com.anushka.livedatademo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel(startingValue: Int) : ViewModel() {

    private var _totalSum = MutableStateFlow<Int>(0)
    val totalSum: StateFlow<Int> = _totalSum

    private var _message = MutableSharedFlow<String>()
    var message: SharedFlow<String> = _message

    init {
        _totalSum.value = startingValue
    }

    fun sumNumberInput(number: Int) {
        _totalSum.value = _totalSum.value.plus(number)
        viewModelScope.launch {
            _message.emit("Total updated successfully!")
        }
    }
}