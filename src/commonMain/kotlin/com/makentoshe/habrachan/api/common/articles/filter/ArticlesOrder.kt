package com.makentoshe.habrachan.api.common.articles.filter

sealed class ArticlesOrder {
    abstract val value: String

    object Relevance : ArticlesOrder() {
        override val value: String = "relevance"
    }
    object Date : ArticlesOrder() {
        override val value: String = "date"
    }
    object Rating : ArticlesOrder() {
        override val value: String = "rating"
    }
}