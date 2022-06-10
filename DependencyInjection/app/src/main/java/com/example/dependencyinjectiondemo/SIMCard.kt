package com.example.dependencyinjectiondemo

import android.util.Log

class SIMCard {

    lateinit var serviceProvider: ServiceProvider

    init {
        Log.i("MYTAG","SIM Card Constructed")
    }

    fun getConnection(){
        serviceProvider.getServiceProvider()
    }
}