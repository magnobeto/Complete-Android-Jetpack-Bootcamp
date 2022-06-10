package com.example.dependencyinjectiondemo

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule(val memorySize: Int) {

    @Provides
    fun providesMemmoryCard(): MemoryCard {
        Log.i("MYTAG", "Size of the memory is $memorySize")
        return MemoryCard()
    }
}