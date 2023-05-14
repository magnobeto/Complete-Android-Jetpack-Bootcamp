package com.example.appnews.domain.usecase

import com.example.appnews.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, searchQuery: String, page: Int) =
        newsRepository.getSearchedNews(country, searchQuery, page)
}