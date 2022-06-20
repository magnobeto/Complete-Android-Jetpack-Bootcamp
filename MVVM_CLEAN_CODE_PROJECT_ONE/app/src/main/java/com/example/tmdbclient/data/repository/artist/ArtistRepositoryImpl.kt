package com.example.tmdbclient.data.repository.artist

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl: ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateArtists(): List<Artist>? {
        TODO("Not yet implemented")
    }
}