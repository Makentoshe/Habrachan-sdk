package com.makentoshe.habrachan.api.common.articles.filter

fun articlesPeriod(value: String) = object : ArticlesPeriod(value) {}

abstract class ArticlesPeriod(val value: String) {
    override fun toString() = "Period($value)"

    object Daily : ArticlesPeriod("daily")

    object Weekly : ArticlesPeriod("weekly")

    object Monthly : ArticlesPeriod("monthly")

    object Yearly : ArticlesPeriod("yearly")

    object Alltime : ArticlesPeriod("alltime")
}
