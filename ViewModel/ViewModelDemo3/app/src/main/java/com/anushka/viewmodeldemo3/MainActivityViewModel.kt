package com.anushka.viewmodeldemo3

import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingValue: Int): ViewModel() {
    
    private var totalSum: Int = 0

    init {
        totalSum = startingValue
    }
    
    fun sumNumberInput(number: Int) {
        totalSum += number
    }

    fun showTotalSum(): Int {
        return totalSum
    }
}