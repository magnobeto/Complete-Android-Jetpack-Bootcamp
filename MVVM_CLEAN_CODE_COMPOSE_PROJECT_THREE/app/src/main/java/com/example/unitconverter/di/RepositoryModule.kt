package com.example.unitconverter.di

import com.example.unitconverter.data.ConverterDAO
import com.example.unitconverter.data.ConverterRepository
import com.example.unitconverter.data.ConverterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideConverterRepository(converterDAO: ConverterDAO): ConverterRepository =
        ConverterRepositoryImpl(converterDAO)
}