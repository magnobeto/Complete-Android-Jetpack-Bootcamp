package com.example.appnews.data.repository.dataSourceImpl

import com.example.appnews.data.db.ArticleDAO
import com.example.appnews.data.model.Article
import com.example.appnews.data.repository.dataSource.NewsLocalDataSource

class NewsLocalDataSourceImpl(private val articleDAO: ArticleDAO) : NewsLocalDataSource {
    override suspend fun saveNews(article: Article) = articleDAO.insertArticle(article)
}