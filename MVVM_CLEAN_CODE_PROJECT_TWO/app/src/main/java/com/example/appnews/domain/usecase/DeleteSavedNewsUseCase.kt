package com.example.appnews.domain.usecase

import com.example.appnews.data.model.Article
import com.example.appnews.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.deleteNewsArticle(article)
}