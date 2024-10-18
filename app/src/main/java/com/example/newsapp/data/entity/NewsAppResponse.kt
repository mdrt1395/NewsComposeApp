package com.example.newsapp.data.entity

data class NewsAppResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

data class Article (
    val author: String?= null,
    val title: String?= null,
    val description: String? = null,
    val url: String?= null,
    val urlToImage:String?= null,
    val publishedAt: String?= null,
    val content: String?= null,
    val source: Source
)

data class Source (
        val id: String?= null,
    val name: String?= null
        )
