package com.anushka.livedatachallenge

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var count = 0

    fun getCurrentCount():Int{
        return count
    }

    fun getUpdatedCount():Int{
        return ++count
    }
}