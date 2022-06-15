package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.data.model.movie.Movie

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}