package com.example.unitconverter.presentation.di

import com.example.unitconverter.data.db.ConverterDAO
import com.example.unitconverter.data.repository.ConverterRepository
import com.example.unitconverter.data.repository.ConverterRepositoryImpl
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