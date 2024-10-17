package com.example.newsapp.data.datasource

import com.example.newsapp.data.entity.NewsAppResponse
import okhttp3.Response

interface NewsAppDataSource {

    suspend fun getNewsHeadline(
        country: String
    ): Response<NewsAppResponse>

}