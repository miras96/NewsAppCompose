package com.example.newsappcompose.domain.interactor

import com.example.newsappcompose.data.NewsRepository
import com.example.newsappcompose.domain.mapper.RemoteToDomainNewsMapper
import com.example.newsappcompose.model.domain.Either
import com.example.newsappcompose.model.domain.ErrorDomain
import com.example.newsappcompose.model.domain.NewsDomain
import javax.inject.Inject

class NewsInteractor @Inject constructor(
    private val repository: NewsRepository,
    private val mapper: RemoteToDomainNewsMapper
) {

    suspend fun getNews(): Either<NewsDomain, ErrorDomain> =
        mapper.convert(repository.loadNews())

    suspend fun getNews(query: String) {

    }
}