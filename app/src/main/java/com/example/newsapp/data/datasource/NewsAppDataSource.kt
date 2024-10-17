package com.example.newsapp.data.datasource

import com.example.newsapp.data.entity.NewsAppResponse
import retrofit2.Response

interface NewsAppDataSource {

    suspend fun getNewsHeadline(
        country: String
    ): Response<NewsAppResponse>

}