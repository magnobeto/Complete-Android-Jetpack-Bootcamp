package com.example.appnews.data.repository.dataSourceImpl

import com.example.appnews.data.db.ArticleDAO
import com.example.appnews.data.model.Article
import com.example.appnews.data.repository.dataSource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(private val articleDAO: ArticleDAO) : NewsLocalDataSource {
    override suspend fun saveNews(article: Article) = articleDAO.insertArticle(article)
    override suspend fun deleteNews(article: Article) = articleDAO.deleteArticle(article)
    override fun getAllSaveNews(): Flow<List<Article>> = articleDAO.getAllSavedArticles()
}