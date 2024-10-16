package com.example.newsapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsAppViewModel @Inject constructor():ViewModel() {

    init {
        Log.d(TAG, "Init block of NewsAppViewModel")
    }

    companion object {
        const val TAG = "NewsAppViewModel"
    }

}