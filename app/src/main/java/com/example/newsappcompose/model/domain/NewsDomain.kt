package com.example.newsappcompose.model.domain

import com.example.newsappcompose.model.data.remote.SourceRemote

data class NewsDomain(
    val totalResults: Int,
    val articles: ArrayList<ArticleDomain>,
)

data class ArticleDomain(
    val source: SourceRemote,
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)
