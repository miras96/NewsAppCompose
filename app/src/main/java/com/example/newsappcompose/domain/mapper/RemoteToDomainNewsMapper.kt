package com.example.newsappcompose.domain.mapper

import com.example.newsappcompose.model.data.remote.ArticleRemote
import com.example.newsappcompose.model.data.remote.NewsRemote
import com.example.newsappcompose.model.domain.ArticleDomain
import com.example.newsappcompose.model.domain.Either
import com.example.newsappcompose.model.domain.ErrorDomain
import com.example.newsappcompose.model.domain.NewsDomain
import com.example.newsappcompose.model.domain.left
import com.example.newsappcompose.model.domain.right

class RemoteToDomainNewsMapper {

    fun convert(from: NewsRemote): Either<NewsDomain, ErrorDomain> =
        when (from.status) {
            NewsRemote.success() -> NewsDomain(
                totalResults = from.totalResults,
                articles = from.articles.map { it.toDomain() } as ArrayList<ArticleDomain>
            ).left()

            NewsRemote.error() -> ErrorDomain(
                code = from.code ?: "Unknown",
                message = from.message.orEmpty()
            ).right()

            else -> ErrorDomain(
                code = "Unknown",
                message = ""
            ).right()
        }

    private fun ArticleRemote.toDomain(): ArticleDomain =
        ArticleDomain(source, author, title, description, url, urlToImage, publishedAt, content)
}