package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.domain.repository.TvShowRepository
import com.example.tmdbclient.data.model.tvshow.TvShow

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}