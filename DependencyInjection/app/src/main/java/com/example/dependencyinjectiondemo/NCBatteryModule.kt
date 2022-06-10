package com.example.dependencyinjectiondemo

import dagger.Binds
import dagger.Module

@Module
abstract class NCBatteryModule {
    @Binds
    abstract fun bindsCBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery
}