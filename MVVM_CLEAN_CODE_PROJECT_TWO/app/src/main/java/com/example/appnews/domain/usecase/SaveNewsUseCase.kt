package com.example.appnews.domain.usecase

import com.example.appnews.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
}