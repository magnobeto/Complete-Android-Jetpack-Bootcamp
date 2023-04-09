package com.example.appnews.domain.repository

import com.example.appnews.data.model.APIResponse
import com.example.appnews.data.model.Article
import com.example.appnews.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse>
    suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse>
    suspend fun saveNewsArticle(article: Article)
    suspend fun deleteNewsArticle(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}