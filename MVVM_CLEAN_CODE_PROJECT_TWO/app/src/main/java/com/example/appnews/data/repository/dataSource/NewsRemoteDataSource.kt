package com.example.appnews.data.repository.dataSource

import com.example.appnews.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse>
}