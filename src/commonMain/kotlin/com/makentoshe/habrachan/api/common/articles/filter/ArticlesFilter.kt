package com.makentoshe.habrachan.api.common.articles.filter

data class ArticlesFilter(val page: Page, val sort: Sort) {

    data class Page(val value: Int) {
        val key = "page"
    }

    sealed class Sort {

        object All : Sort()

        object Interesting : Sort()

        object MostReading : Sort()

        data class Top(val period: ArticlesPeriod) : Sort()

        object News : Sort()

        data class Search(val query: String, val order: ArticlesOrder): Sort()
    }
}
