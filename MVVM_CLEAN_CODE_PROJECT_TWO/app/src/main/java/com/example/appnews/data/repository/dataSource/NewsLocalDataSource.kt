package com.example.appnews.data.repository.dataSource

import com.example.appnews.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getAllSaveNews(): Flow<List<Article>>
}