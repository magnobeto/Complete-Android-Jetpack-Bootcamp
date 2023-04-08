package com.example.appnews.domain.usecase

import com.example.appnews.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
}