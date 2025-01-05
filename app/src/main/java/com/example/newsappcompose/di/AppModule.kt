package com.example.newsappcompose.di

import com.example.newsappcompose.data.remote.api.RetrofitClient
import com.example.newsappcompose.data.remote.api.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(networkJson: Json): RetrofitClient = RetrofitClient(
        networkJson
    )

    @Provides
    @Singleton
    fun provideRetrofitService(retrofitClient: RetrofitClient): RetrofitService =
        retrofitClient.getClient().create(RetrofitService::class.java)
}