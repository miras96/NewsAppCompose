package com.example.newsappcompose.data.remote.api

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Inject

class RetrofitClient @Inject constructor(
    private val networkJson: Json
) {
    fun getClient(): Retrofit = Retrofit.Builder().run {
        baseUrl(BASE_URL)
        addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        build()
    }

    companion object {
        private const val BASE_URL = "https://newsapi.org/v2/"
    }
}