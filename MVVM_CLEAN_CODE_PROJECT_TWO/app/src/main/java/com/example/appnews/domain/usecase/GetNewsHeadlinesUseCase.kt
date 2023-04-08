package com.example.appnews.domain.usecase

import com.example.appnews.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
}