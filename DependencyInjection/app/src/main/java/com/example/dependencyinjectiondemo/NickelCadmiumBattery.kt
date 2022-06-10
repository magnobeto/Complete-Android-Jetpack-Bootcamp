package com.example.dependencyinjectiondemo

import android.util.Log
import javax.inject.Inject

class NickelCadmiumBattery @Inject constructor() : Battery {
    init {
        Log.i("MYTAG", "Battery Constructed")
    }

    override fun getPower() {
        Log.i("MYTAG", "Power from NickelCadmiumBattery")
    }
}