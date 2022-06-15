package com.example.tmdbclient.data.domain.repository

import com.example.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}