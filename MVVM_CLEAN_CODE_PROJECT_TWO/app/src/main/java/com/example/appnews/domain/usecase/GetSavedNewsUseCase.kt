package com.example.appnews.domain.usecase

import com.example.appnews.domain.repository.NewsRepository

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    fun execute() = newsRepository.getSavedNews()
}