package com.example.tmdbclient.presentation

import android.app.Application
import com.example.tmdbclient.BuildConfig
import com.example.tmdbclient.presentation.di.Injector
import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.core.*
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubcomponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubcomponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}