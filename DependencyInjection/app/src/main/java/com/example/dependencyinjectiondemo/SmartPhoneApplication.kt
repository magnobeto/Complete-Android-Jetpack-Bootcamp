package com.example.dependencyinjectiondemo

import android.app.Application

class SmartPhoneApplication : Application() {

    lateinit var smartPhoneComponent: SmartPhoneComponent

    override fun onCreate() {
        super.onCreate()
        smartPhoneComponent = initDagger()
    }

    private fun initDagger(): SmartPhoneComponent =
        DaggerSmartPhoneComponent.builder()
            .memoryCardModule(MemoryCardModule(1000))
            .build()
}