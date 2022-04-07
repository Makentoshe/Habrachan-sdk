package com.makentoshe.habrachan.api.api.articles

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.api.common.articles.filter.ArticlesFilter
import com.makentoshe.habrachan.api.common.articles.filter.ArticlesFilterScope
import com.makentoshe.habrachan.api.common.articles.filter.ArticlesPeriod

fun HabrahabrApiArticles.filter(filter: ArticlesFilterScope.() -> Unit): HabrahabrApiArticlesByFilter {
    return filter(ArticlesFilterScope().apply(filter).build())
}

fun HabrahabrApiArticles.filter(filter: ArticlesFilter): HabrahabrApiArticlesByFilter {
    return HabrahabrApiArticlesByFilter(path, filter)
}

fun HabrahabrApiArticles.all(page: Int) = filter(ArticlesFilterScope().apply {
    this.page = page
    this.sort = ArticlesFilter.Sort.All
}.build())

fun HabrahabrApiArticles.interesting(page: Int) = filter(ArticlesFilterScope().apply {
    this.page = page
    this.sort = ArticlesFilter.Sort.Interesting
}.build())

fun HabrahabrApiArticles.top(period: ArticlesPeriod, page: Int) = filter(ArticlesFilterScope().apply {
    this.page = page
    this.sort = ArticlesFilter.Sort.Top(period)
}.build())


class HabrahabrApiArticlesByFilter(override val path: CustomStringBuilder, private val filter: ArticlesFilter) :
    ApiRequestBuilder {
    override val queries: Map<String, String> = HashMap<String, String>().apply {
        put(filter.page.key, filter.page.value.toString())

        when (filter.sort) {
            is ArticlesFilter.Sort.All -> path.append("/posts/all")
            is ArticlesFilter.Sort.Top -> path.append("/top/").append(filter.sort.period.value)
            is ArticlesFilter.Sort.Interesting -> path.append("/posts/interesting")
            is ArticlesFilter.Sort.Search -> putSearchSort(filter.sort)
            else -> throw IllegalArgumentException("this sort type doesn't supports")
        }
    }

    private fun HashMap<String, String>.putSearchSort(sort: ArticlesFilter.Sort.Search) {
        path.append("/search/posts/").append(sort.query)
        put("sort", sort.order.value)
        put("get_article", "true")
    }
}
