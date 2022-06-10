package com.example.dependencyinjectiondemo

import android.util.Log
import javax.inject.Inject

class SIMCard @Inject constructor(val serviceProvider: ServiceProvider) {

    init {
        Log.i("MYTAG", "SIM Card Constructed")
    }

    fun getConnection() {
        serviceProvider.getServiceProvider()
    }
}