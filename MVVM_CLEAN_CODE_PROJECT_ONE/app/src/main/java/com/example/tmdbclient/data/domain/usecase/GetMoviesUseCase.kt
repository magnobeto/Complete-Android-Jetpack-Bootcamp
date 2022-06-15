package com.example.tmdbclient.data.domain.usecase

import com.example.tmdbclient.data.domain.repository.MovieRepository
import com.example.tmdbclient.data.model.movie.Movie

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}