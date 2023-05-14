package com.example.appnews.data.repository.dataSourceImpl

import com.example.appnews.data.api.NewsAPIService
import com.example.appnews.data.model.APIResponse
import com.example.appnews.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService
) : NewsRemoteDataSource {

    override suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse> =
        newsAPIService.getTopHeadlines(country, page)

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ) = newsAPIService.getSearchedTopHeadlines(country, searchQuery, page)
}