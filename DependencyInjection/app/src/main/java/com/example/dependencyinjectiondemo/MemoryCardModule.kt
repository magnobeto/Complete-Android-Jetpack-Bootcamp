package com.example.dependencyinjectiondemo

import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule {

    @Provides
    fun providesMemmoryCard(): MemoryCard {
        return MemoryCard()
    }
}