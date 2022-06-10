package com.example.dependencyinjectiondemo

import dagger.Component

@Component(modules = [MemoryCardModule::class, NCBatteryModule::class])
interface SmartPhoneComponent {
    fun getSmartPhone(): SmartPhone
}