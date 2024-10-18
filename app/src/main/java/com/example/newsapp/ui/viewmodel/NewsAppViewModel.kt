package com.example.newsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.AppConstants
import com.example.newsapp.data.entity.NewsAppResponse
import com.example.newsapp.ui.repository.NewsAppRepository
import com.example.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsAppViewModel @Inject constructor(
    private val newsAppRepository: NewsAppRepository
):ViewModel() {

    private val _news: MutableStateFlow<ResourceState<NewsAppResponse>> = MutableStateFlow(ResourceState.Loading())
    val news : StateFlow<ResourceState<NewsAppResponse>> = _news

    init {
        getNews(AppConstants.COUNTRY)
    }

    private fun getNews(country: String){
        //Dispatchers.IO makes the following code run on a background thread
        viewModelScope.launch (Dispatchers.IO) {
            newsAppRepository.getNewsAppHeadline(country)
                .collectLatest { newsAppResponse ->
                    _news.value = newsAppResponse
                }
        }
    }

    companion object {
        const val TAG = "NewsAppViewModel"
    }

}