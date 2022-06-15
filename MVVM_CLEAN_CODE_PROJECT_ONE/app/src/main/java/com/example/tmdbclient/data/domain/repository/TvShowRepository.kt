package com.example.tmdbclient.data.domain.repository

import com.example.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}