package com.example.dependencyinjectiondemo

import android.util.Log

class SIMCard(val serviceProvider: ServiceProvider) {

    init {
        Log.i("MYTAG", "SIM Card Constructed")
    }

    fun getConnection() {
        serviceProvider.getServiceProvider()
    }
}