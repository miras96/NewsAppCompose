package com.example.newsappcompose.model.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class NewsRemote(
    val status: String,
    val totalResults: Int,
    val articles: ArrayList<ArticleRemote>,
    val code: String? = null,
    val message: String? = null
)

@Serializable
data class ArticleRemote(
    val source: SourceRemote,
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)

@Serializable
data class SourceRemote(
    val id: String?,
    val name: String
)