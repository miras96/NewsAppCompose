package com.example.newsappcompose.model.domain

sealed class Either<out L, out R> {

    data class Left<out L, out R>(val a: L) : Either<L, R>()

    data class Right<out L, out R>(val b: R) : Either<L, R>()

}

fun <E> E.left() = Either.Left<E, Nothing>(this)

fun <T> T.right() = Either.Right<Nothing, T>(this)