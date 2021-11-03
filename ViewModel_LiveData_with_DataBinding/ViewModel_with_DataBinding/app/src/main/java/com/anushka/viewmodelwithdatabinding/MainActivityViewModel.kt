package com.anushka.viewmodelwithdatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var countLV = MutableLiveData<Int>(0)
    val count: LiveData<Int> = countLV

    fun updateCount() {
        countLV.value = countLV.value?.plus(1)
    }
}