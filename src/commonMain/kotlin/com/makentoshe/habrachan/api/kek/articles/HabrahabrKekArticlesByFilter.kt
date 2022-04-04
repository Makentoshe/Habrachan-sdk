package com.makentoshe.habrachan.api.kek.articles

import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.api.common.articles.filter.ArticlesFilter
import com.makentoshe.habrachan.api.common.articles.filter.ArticlesFilterScope
import com.makentoshe.habrachan.api.common.articles.filter.ArticlesOrder
import com.makentoshe.habrachan.api.common.articles.filter.ArticlesPeriod

fun HabrahabrKekArticles.filter(filter: ArticlesFilterScope.() -> Unit): HabrahabrKekArticlesByFilter {
    return filter(ArticlesFilterScope().apply(filter).build())
}

fun HabrahabrKekArticles.filter(filter: ArticlesFilter): HabrahabrKekArticlesByFilter {
    return HabrahabrKekArticlesByFilter(path, filter)
}

//https://habr.com/kek/v2/articles/?fl=en%2Cru&page=1&sort=rating
fun HabrahabrKekArticles.all(page: Int) = filter(ArticlesFilterScope().apply {
    this.page = page
    this.sort = ArticlesFilter.Sort.All
}.build())

//https://habr.com/kek/v2/articles/most-reading?fl=en%2Cru&page=1
fun HabrahabrKekArticles.mostReading(page: Int) = filter(ArticlesFilterScope().apply {
    this.page = page
    this.sort = ArticlesFilter.Sort.MostReading
}.build())

//https://habr.com/kek/v2/articles/?fl=en%2Cru&page=1&period=daily&sort=date
fun HabrahabrKekArticles.top(period: ArticlesPeriod, page: Int) = filter(ArticlesFilterScope().apply {
    this.page = page
    this.sort = ArticlesFilter.Sort.Top(period)
}.build())

//https://habr.com/kek/v2/articles/?news=true&fl=en%2Cru&hl=en&page=1
fun HabrahabrKekArticles.news(page: Int) = filter(ArticlesFilterScope().apply {
    this.page = page
    this.sort = ArticlesFilter.Sort.News
}.build())

//https://habr.com/kek/v2/articles/?query=latex&order=relevance&fl=en%2Cru&hl=en&page=1
fun HabrahabrKekArticles.find(query: String, order: ArticlesOrder, page: Int) = filter(ArticlesFilterScope().apply {
    this.page = page
    this.sort = ArticlesFilter.Sort.Search(query, order)
}.build())

class HabrahabrKekArticlesByFilter(override val path: StringBuilder, private val filter: ArticlesFilter) :
    ApiRequestBuilder {
    override val queries: Map<String, String> = HashMap<String, String>().apply {
        put(filter.page.key, filter.page.value.toString())

        when (filter.sort) {
            is ArticlesFilter.Sort.All -> put("sort", "rating")
            is ArticlesFilter.Sort.MostReading -> path.append("/").append("most-reading")
            is ArticlesFilter.Sort.News -> put("news", "true")
            is ArticlesFilter.Sort.Top -> putTopSort(filter.sort)
            is ArticlesFilter.Sort.Search -> putFindSort(filter.sort)
            else -> throw IllegalArgumentException("this sort doesn't supports")
        }
    }

    private fun HashMap<String, String>.putFindSort(filter: ArticlesFilter.Sort.Search) {
        put("order", filter.order.value)
        put("query", filter.query)
    }

    private fun HashMap<String, String>.putTopSort(filter: ArticlesFilter.Sort.Top) {
        put("sort", "rating"); put("period", filter.period.value)
    }
}
