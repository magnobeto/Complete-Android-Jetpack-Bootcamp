package com.example.unitconverter.di

import android.app.Application
import androidx.room.Room
import com.example.unitconverter.data.ConverterDAO
import com.example.unitconverter.data.ConverterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideConverterDatabase(app: Application): ConverterDatabase =
        Room.databaseBuilder(app, ConverterDatabase::class.java, "converter_data_database").build()

    @Singleton
    @Provides
    fun provideConverterDao(tmdbDatabase: ConverterDatabase): ConverterDAO =
        tmdbDatabase.converterDAO()
}