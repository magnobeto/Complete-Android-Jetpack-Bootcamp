package com.anushka.livedatademo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingValue: Int) : ViewModel() {

    private var totalSumLV = MutableLiveData<Int>()
    val totalSum: LiveData<Int> = totalSumLV
    val inputText = MutableLiveData<String>()

    init {
        totalSumLV.value = startingValue
    }

    fun sumNumberInput() {
        val inputNumber = inputText.value.toString().toInt()
        totalSumLV.value = totalSumLV.value?.plus(inputNumber)
    }
}