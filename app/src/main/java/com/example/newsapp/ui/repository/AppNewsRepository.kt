package com.example.newsapp.ui.repository

import com.example.newsapp.data.datasource.NewsAppDataSource
import com.example.newsapp.data.entity.NewsAppResponse
import com.example.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class NewsAppRepository @Inject constructor(
    private val newsAppDataSource: NewsAppDataSource
) {
    //    suspend fun getNewsAppHeadline(country:String): Response<NewsAppResponse>{
//        return newsAppDataSource.getNewsHeadline(country)
//    }
    suspend fun getNewsAppHeadline(country: String): Flow<ResourceState<NewsAppResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = newsAppDataSource.getNewsHeadline(country)
            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error fetching news data"))
            }
        }.catch { e ->
            emit(ResourceState.Error(e?.localizedMessage ?: "Some error has occurred in flow"))
        }
    }
}