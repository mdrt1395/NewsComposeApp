package com.example.newsapp.data.datasource

import com.example.newsapp.data.api.ApiService
import com.example.newsapp.data.entity.NewsAppResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsAppDataSource {

    override suspend fun getNewsHeadline(country: String): Response<NewsAppResponse> {
        return apiService.getNewsHeadline(country)
    }
}