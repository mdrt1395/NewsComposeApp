package com.example.newsapp.data.api

import com.example.newsapp.data.entity.NewsAppResponse
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //Minutes 42-44

    @GET("v2/top-headlines")
    fun getNewsHeadline(
        @Query("country") country: String, @Query("apiKey") apiKey: String = "YOUR_API_KEY"
    ): Response <NewsAppResponse>


}