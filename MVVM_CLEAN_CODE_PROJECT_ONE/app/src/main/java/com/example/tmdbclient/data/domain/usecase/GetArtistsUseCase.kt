package com.example.tmdbclient.data.domain.usecase

import com.example.tmdbclient.data.domain.repository.ArtistRepository
import com.example.tmdbclient.data.model.artist.Artist

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}