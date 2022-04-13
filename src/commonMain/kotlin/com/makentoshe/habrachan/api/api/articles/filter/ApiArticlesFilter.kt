package com.makentoshe.habrachan.api.api.articles.filter

import com.makentoshe.habrachan.entity.UserLogin

sealed class ArticlesFlow {
    object Develop : ArticlesFlow()
    object PopSci : ArticlesFlow()
    object Admin : ArticlesFlow()
    object Design : ArticlesFlow()
    object Management : ArticlesFlow()
    object Marketing : ArticlesFlow()
}

sealed class ArticlesOrder {
    object Relevance : ArticlesOrder()
    object Date : ArticlesOrder()
    object Rating : ArticlesOrder()
}

sealed class ArticlesPeriod {
    object Daily : ArticlesPeriod()
    object Weekly : ArticlesPeriod()
    object Monthly : ArticlesPeriod()
    object Yearly : ArticlesPeriod()
    object Alltime : ArticlesPeriod()
}

data class ApiArticlesFilter(
    val sort: Sort,
    val page: Page = Page(1),
    val include: Include = Include(emptyList()),
    val exclude: Exclude = Exclude(emptyList()),
) {

    data class Page(val value: Int) {
        val key = "page"
    }

    data class Include(val fields: List<String>)

    data class Exclude(val fields: List<String>)

    sealed class Sort {
        object Feed : Sort()

        object All : Sort()
        object Interesting : Sort()
        data class Top(val period: ArticlesPeriod) : Sort()

        data class Query(val query: String, val order: ArticlesOrder) : Sort()

        data class Flow(val flow: ArticlesFlow) : Sort()

        sealed class Hub : Sort() {
            abstract val title: String

            data class All(override val title: String) : Hub()
            data class Interesting(override val title: String) : Hub()
//            data class Top(val period: ArticlesPeriod): Sort()
        }

        data class User(val login: UserLogin): Sort()
    }

}
