package com.makentoshe.habrachan.api.common

interface ApiRequestIterable: ApiRequestBuilder {

    fun page(value: Int): ApiRequestBuilder

    fun next(): ApiRequestIterable

    fun previous(): ApiRequestIterable
}