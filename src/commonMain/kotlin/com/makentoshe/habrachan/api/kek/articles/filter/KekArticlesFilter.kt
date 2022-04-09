package com.makentoshe.habrachan.api.kek.articles.filter

import com.makentoshe.habrachan.entity.UserLogin

data class KekArticlesFilter(
    val page: Page,
    val sort: Sort,
    val user: User,
    val flow: Flow,
    val period: Period,
    val custom: Custom,
    val score: Score,
    val flowNews: FlowNews,
    val news: News,
    val hub: Hub,
    val query: Query,
    val order: Order,
) {

    data class Page(val value: Int) {
        val key = "page"
    }

    // This value might be undefined
    sealed class User {
        object None : User()

        data class Value(val login: UserLogin) : User()
    }

    // This value might be undefined
    sealed class Flow {
        object None : Flow()

        object Develop : Flow()
        object PopSci : Flow()
        object Admin : Flow()
        object Design : Flow()
        object Management : Flow()
        object Marketing : Flow()
    }

    // This value might be undefined
    sealed class Custom {
        object None : Custom()

        data class Value(val value: Boolean) : Custom()
    }

    // This value might be undefined
    sealed class Period {
        object None : Period()

        object Daily : Period()
        object Weekly : Period()
        object Monthly : Period()
        object Yearly : Period()
        object Alltime : Period()
    }

    // This value might be undefined
    sealed class Score {
        object None : Score()

        data class Value(val score: Int) : Score()
    }

    // This value might be undefined
    sealed class FlowNews {
        object None : FlowNews()

        data class Value(val value: Boolean) : FlowNews()
    }

    // This value might be undefined
    sealed class News {
        object None : News()

        data class Value(val value: Boolean) : News()
    }

    // This value might be undefined
    sealed class Hub {
        object None : Hub()

        data class Custom(val value: String) : Hub()
    }

    // This value might be undefined
    sealed class Query {
        object None : Query()

        data class Value(val value: String) : Query()
    }

    // This value might be undefined
    sealed class Order {
        object None : Order()

        object Relevance : Order()
        object Date : Order()
        object Rating : Order()
    }

    sealed class Sort {
        object None : Sort()

        object All : Sort()
        object Date : Sort()
        object Rating : Sort()
    }
}
