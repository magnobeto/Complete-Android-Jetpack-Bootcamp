package com.example.appnews.data.repository.dataSourceImpl

import com.example.appnews.data.api.NewsAPIService
import com.example.appnews.data.model.APIResponse
import com.example.appnews.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
    private val country: String,
    private val page: Int
) : NewsRemoteDataSource {

    override suspend fun getTopHeadlines(): Response<APIResponse> =
        newsAPIService.getTopHeadlines(page, country)
}