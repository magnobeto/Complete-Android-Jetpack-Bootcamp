package com.example.tmdbclient.presentation.di.core

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.TMDBDatabase
import com.example.tmdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMovieDataBase(app: Application): TMDBDatabase {
        return Room.databaseBuilder(app, TMDBDatabase::class.java, "tmdbclient").build()
    }
    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }
    @Singleton
    @Provides
    fun provideTvDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvDao()
    }
    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }
}