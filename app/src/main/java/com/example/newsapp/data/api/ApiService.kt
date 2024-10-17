package com.example.newsapp.data.api

import com.example.newsapp.data.entity.NewsAppResponse
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //Minutes 42-44

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String, @Query("apiKey") apiKey: String = "3d895f7cf98747078b0d5c17aa7be7a5"
    ): retrofit2.Response <NewsAppResponse>


}