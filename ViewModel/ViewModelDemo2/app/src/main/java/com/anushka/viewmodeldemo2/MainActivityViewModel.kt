package com.anushka.viewmodeldemo2

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    
    private var totalSum: Int = 0
    
    fun sumNumberInput(number: Int) {
        totalSum += number
    }

    fun showTotalSum(): Int {
        return totalSum
    }
}