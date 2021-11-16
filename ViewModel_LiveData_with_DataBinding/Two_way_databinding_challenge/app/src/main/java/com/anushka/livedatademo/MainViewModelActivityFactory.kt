package com.anushka.livedatademo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelActivityFactory(private var startingValue: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(startingValue) as T
        }
        throw IllegalArgumentException("Unknow ViewModel Class")
    }
}