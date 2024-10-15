package com.example.newsapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsapp.ui.viewmodel.NewsAppViewModel

@Composable
fun HomeScreen(
    newsAppViewModel: NewsAppViewModel = hiltViewModel()
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)


    ) { }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}