package com.example.appnews.presentation.di

import com.example.appnews.data.repository.NewsRepositoryImpl
import com.example.appnews.data.repository.dataSource.NewsLocalDataSource
import com.example.appnews.data.repository.dataSource.NewsRemoteDataSource
import com.example.appnews.domain.repository.NewsRepository
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
    fun providesNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource)
    }
}