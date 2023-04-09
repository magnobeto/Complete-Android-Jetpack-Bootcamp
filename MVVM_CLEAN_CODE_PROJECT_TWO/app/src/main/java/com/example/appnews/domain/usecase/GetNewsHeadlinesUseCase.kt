package com.example.appnews.domain.usecase

import com.example.appnews.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, page: Int) = newsRepository.getNewsHeadlines(country, page)
}