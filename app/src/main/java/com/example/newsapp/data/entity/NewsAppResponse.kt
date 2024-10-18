package com.example.newsapp.data.entity

data class NewsAppResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

data class Article (
    val author: String,
    val title: String,
    val description: String? = null,
    val url: String,
    val urlToImage:String?= null,
    val publishedAt: String,
    val content: String?= null,
    val source: Source
)

data class Source (
        val id: String,
    val name: String
        )
