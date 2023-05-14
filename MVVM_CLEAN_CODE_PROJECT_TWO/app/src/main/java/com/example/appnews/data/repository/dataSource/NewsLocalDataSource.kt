package com.example.appnews.data.repository.dataSource

import com.example.appnews.data.model.Article

interface NewsLocalDataSource {
    suspend fun saveNews(article: Article)
}