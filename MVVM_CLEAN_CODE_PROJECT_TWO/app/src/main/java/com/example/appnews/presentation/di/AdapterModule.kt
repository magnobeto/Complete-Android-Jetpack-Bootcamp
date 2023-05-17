package com.example.appnews.presentation.di

import com.example.appnews.presentation.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Provides
    fun provideNewsAdapter() = NewsAdapter()
}