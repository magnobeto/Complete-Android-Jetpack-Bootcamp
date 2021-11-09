package com.example.twowaydatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private var userNameLV = MutableLiveData<String>()
    var userName : LiveData<String> = userNameLV

    init {
        userNameLV.value = "Frank"
    }
}