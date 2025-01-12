package com.example.newsappcompose.data

import android.content.Context
import com.example.newsappcompose.BuildConfig
import com.example.newsappcompose.R
import com.example.newsappcompose.data.remote.api.RetrofitService
import com.example.newsappcompose.model.data.remote.NewsRemote
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val retrofitService: RetrofitService,
    private val context: Context
) {
    suspend fun loadNews(): NewsRemote = retrofitService.getLatestNews(
        getCountryCode(),
        BuildConfig.NEWS_API_KEY
    )

    private fun getCountryCode() = context.getString(R.string.country_default_value)
}