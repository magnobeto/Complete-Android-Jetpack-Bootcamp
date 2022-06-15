package com.example.tmdbclient.data.domain.usecase

import com.example.tmdbclient.data.domain.repository.TvShowRepository
import com.example.tmdbclient.data.model.tvshow.TvShow

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}