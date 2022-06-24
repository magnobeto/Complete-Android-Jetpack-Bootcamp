package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubcomponent(): MovieSubComponent
    fun createTvShowSubcomponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}