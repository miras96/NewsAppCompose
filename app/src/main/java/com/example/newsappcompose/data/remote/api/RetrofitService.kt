package com.example.newsappcompose.data.remote.api

import com.example.newsappcompose.model.data.remote.NewsRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("top-headlines")
    suspend fun getLatestNews(@Query("country") country: String, @Query("apiKey") apiKey: String): NewsRemote
}