package com.example.tmdbclient.data.repository.tvshow

import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl: TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        TODO("Not yet implemented")
    }
}