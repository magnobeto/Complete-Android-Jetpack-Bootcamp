package com.example.appnews.data.repository

import com.example.appnews.data.model.APIResponse
import com.example.appnews.data.model.Article
import com.example.appnews.data.repository.dataSource.NewsLocalDataSource
import com.example.appnews.data.repository.dataSource.NewsRemoteDataSource
import com.example.appnews.data.util.Resource
import com.example.appnews.domain.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
) : NewsRepository {
    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country, page))
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getSearchedNews(country, searchQuery, page))
    }

    override suspend fun saveNewsArticle(article: Article) = newsLocalDataSource.saveNews(article)

    override suspend fun deleteNewsArticle(article: Article) = newsLocalDataSource.deleteNews(article)

    override fun getSavedNews(): Flow<List<Article>> = newsLocalDataSource.getAllSaveNews()

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(message = response.message())
    }
}