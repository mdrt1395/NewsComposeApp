package com.example.newsapp.ui.screens

import Loader
import NewsList
import NewsRowComponent
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsapp.ui.viewmodel.NewsAppViewModel
import com.example.utilities.ResourceState

const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    newsAppViewModel: NewsAppViewModel = hiltViewModel()
) {

    val newsResponse by newsAppViewModel.news.collectAsState()

    val pagerState = rememberPagerState(0, 0f) {
        100
    }

    VerticalPager(
        pagerState, modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill, pageSpacing = 8.dp
    ) { page: Int ->

        when (newsResponse) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Inside_Loading")
                Loader()
            }

            is ResourceState.Success -> {
                val response = (newsResponse as ResourceState.Success).data
                Log.d(TAG, "Success ${response.status} = ${response.totalResults} ")

                if(response.articles.isNotEmpty()){
                    NewsRowComponent(page, response.articles.get(page))
                } else {

                }

            }

            is ResourceState.Error -> {
                val error = (newsResponse as ResourceState.Error)
                Log.d(TAG, "Inside_Error ${error}")
            }
        }

    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}