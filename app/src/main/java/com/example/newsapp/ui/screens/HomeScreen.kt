package com.example.newsapp.ui.screens

import Loader
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsapp.ui.viewmodel.NewsAppViewModel
import com.example.utilities.ResourceState

const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    newsAppViewModel: NewsAppViewModel = hiltViewModel()
) {

    val newsResponse by newsAppViewModel.news.collectAsState()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        when(newsResponse){
            is ResourceState.Loading -> {
                Log.d(TAG, "Inside_Loading")
                Loader()
            }

            is ResourceState.Success -> {
                Log.d(TAG, "Success")
            }

            is ResourceState.Error -> {
                Log.d(TAG, "Inside_Error")
            }
        }

    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}