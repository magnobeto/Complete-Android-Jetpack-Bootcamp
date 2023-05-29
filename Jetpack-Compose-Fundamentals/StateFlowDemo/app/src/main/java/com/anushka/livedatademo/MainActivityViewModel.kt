package com.anushka.livedatademo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingValue: Int): ViewModel() {
    
    private var totalSumLV = MutableLiveData<Int>()
    val totalSum: LiveData<Int> = totalSumLV

    init {
        totalSumLV.value = startingValue
    }

    fun sumNumberInput(number: Int) {
        totalSumLV.value = totalSumLV.value?.plus(number)
    }
}