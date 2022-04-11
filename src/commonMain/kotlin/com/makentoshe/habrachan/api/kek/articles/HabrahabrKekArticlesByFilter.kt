package com.makentoshe.habrachan.api.kek.articles

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequest
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.api.common.ApiRequestIterable
import com.makentoshe.habrachan.api.kek.articles.filter.KekArticlesFilter
import com.makentoshe.habrachan.api.kek.articles.filter.KekArticlesFilterScope

fun HabrahabrKekArticles.filter(filter: KekArticlesFilterScope.() -> Unit): HabrahabrKekArticlesByFilter {
    return filter(KekArticlesFilterScope().apply(filter).build())
}

fun HabrahabrKekArticles.filter(filter: KekArticlesFilter): HabrahabrKekArticlesByFilter {
    return HabrahabrKekArticlesByFilter(path, filter)
}

data class HabrahabrKekArticlesByFilter internal constructor(
    override val path: CustomStringBuilder,
    internal val filter: KekArticlesFilter,
) : ApiRequestBuilder, ApiRequestIterable {

    override val queries: Map<String, String> = HashMap<String, String>().apply {
        filter.apply {
            putSortFilter(sort)
            putPageFilter(page)
            putUserFilter(user)
            putFlowFilter(flow)
            putPeriodFilter(period)
            putCustomFilter(custom)
            putScoreFilter(score)
            putFlowNewsFilter(flowNews)
            putNewsFilter(news)
            putFlowFilter(flow)
            putHubFilter(hub)
            putQueryFilter(query)
            putOrderFilter(order)
        }
    }

    override fun page(value: Int): ApiRequestBuilder {
        return copy(path = path, filter = filter.copy(page = KekArticlesFilter.Page(value)))
    }

    override fun next(): ApiRequestIterable {
        return copy(path = path, filter = filter.copy(page = filter.page.copy(value = filter.page.value + 1)))
    }

    override fun previous(): ApiRequestIterable {
        return copy(path = path, filter = filter.copy(page = filter.page.copy(value = filter.page.value - 1)))
    }

    private fun HashMap<String, String>.putPageFilter(page: KekArticlesFilter.Page) {
        put(page.key, page.value.toString())
    }

    private fun HashMap<String, String>.putSortFilter(sort: KekArticlesFilter.Sort) {
        when (sort) {
            is KekArticlesFilter.Sort.None -> Unit
            is KekArticlesFilter.Sort.All -> put("sort", "all")
            is KekArticlesFilter.Sort.Date -> put("sort", "date")
            is KekArticlesFilter.Sort.Rating -> put("sort", "rating")
        }
    }

    private fun HashMap<String, String>.putUserFilter(user: KekArticlesFilter.User) {
        when (user) {
            is KekArticlesFilter.User.None -> Unit
            is KekArticlesFilter.User.Value -> put("user", user.login.login)
        }
    }

    private fun HashMap<String, String>.putFlowFilter(flow: KekArticlesFilter.Flow) {
        when (flow) {
            is KekArticlesFilter.Flow.None -> Unit
            is KekArticlesFilter.Flow.Develop -> put("flow", "develop")
            is KekArticlesFilter.Flow.Admin -> put("flow", "admin")
            is KekArticlesFilter.Flow.Design -> put("flow", "design")
            is KekArticlesFilter.Flow.Management -> put("flow", "management")
            is KekArticlesFilter.Flow.Marketing -> put("flow", "marketing")
            is KekArticlesFilter.Flow.PopSci -> put("flow", "popsci")
        }
    }

    private fun HashMap<String, String>.putPeriodFilter(period: KekArticlesFilter.Period) {
        when (period) {
            is KekArticlesFilter.Period.None -> Unit
            is KekArticlesFilter.Period.Alltime -> put("period", "alltime")
            is KekArticlesFilter.Period.Yearly -> put("period", "yearly")
            is KekArticlesFilter.Period.Monthly -> put("period", "monthly")
            is KekArticlesFilter.Period.Weekly -> put("period", "weekly")
            is KekArticlesFilter.Period.Daily -> put("period", "deily")
        }
    }

    private fun HashMap<String, String>.putCustomFilter(custom: KekArticlesFilter.Custom) {
        when (custom) {
            is KekArticlesFilter.Custom.None -> Unit
            is KekArticlesFilter.Custom.Value -> put("custom", custom.value.toString())
        }
    }

    private fun HashMap<String, String>.putScoreFilter(score: KekArticlesFilter.Score) {
        when (score) {
            is KekArticlesFilter.Score.None -> Unit
            is KekArticlesFilter.Score.Value -> put("score", score.score.toString())
        }
    }

    private fun HashMap<String, String>.putFlowNewsFilter(flowNews: KekArticlesFilter.FlowNews) {
        when (flowNews) {
            is KekArticlesFilter.FlowNews.None -> Unit
            is KekArticlesFilter.FlowNews.Value -> put("flowNews", flowNews.value.toString())
        }
    }

    private fun HashMap<String, String>.putNewsFilter(news: KekArticlesFilter.News) {
        when (news) {
            is KekArticlesFilter.News.None -> Unit
            is KekArticlesFilter.News.Value -> put("news", news.value.toString())
        }
    }

    private fun HashMap<String, String>.putHubFilter(hub: KekArticlesFilter.Hub) {
        when (hub) {
            is KekArticlesFilter.Hub.None -> Unit
            is KekArticlesFilter.Hub.Custom -> put("hub", hub.value)
        }
    }

    private fun HashMap<String, String>.putQueryFilter(query: KekArticlesFilter.Query) {
        when (query) {
            is KekArticlesFilter.Query.None -> Unit
            is KekArticlesFilter.Query.Value -> put("query", query.value)
        }
    }

    private fun HashMap<String, String>.putOrderFilter(order: KekArticlesFilter.Order) {
        when (order) {
            is KekArticlesFilter.Order.None -> Unit
            is KekArticlesFilter.Order.Date -> put("order", "date")
            is KekArticlesFilter.Order.Rating -> put("order", "rating")
            is KekArticlesFilter.Order.Relevance -> put("order", "relevance")
        }
    }

}
// Just to not forget for future...
//https://habr.com/kek/v2/articles/?user=Milfgard&fl=en%2Cru&hl=en&page=1
//fun HabrahabrKekArticles.user(login: UserLogin, page: Int) = filter {
//    this.user = ArticlesFilter.User.Value(login)
//    this.page = ArticlesFilter.Page(page)
//}
//
//https://habr.com/kek/v2/articles/?custom=true&fl=en%2Cru&hl=en&page=3
//fun HabrahabrKekArticles.feed(page: Int) = filter {
//    this.page = ArticlesFilter.Page(page)
//    this.custom = ArticlesFilter.Custom.Value(true)
//}
//
//https://habr.com/kek/v2/articles/?flow=develop&score=0&sort=all&fl=en%2Cru&hl=en&page=1
//fun HabrahabrKekArticles.all(flow: ArticlesFilter.Flow, page: Int) = filter {
//    this.page = ArticlesFilter.Page(page)
//    this.sort = ArticlesFilter.Sort.All
//    this.flow = flow
//}
//
// https://habr.com/kek/v2/articles/?flow=popsci&period=alltime&sort=all&fl=en%2Cru&hl=en&page=1
//fun HabrahabrKekArticles.top(flow: ArticlesFilter.Flow, period: ArticlesFilter.Period, page: Int) = filter {
//    this.page = ArticlesFilter.Page(page)
//    this.sort = ArticlesFilter.Sort.All
//    this.flow = flow
//}
////https://habr.com/kek/v2/articles/?fl=en%2Cru&page=1&sort=rating
//fun HabrahabrKekArticles.all(page: Int) = filter(ArticlesFilterScope().apply {
//    this.page = page
//    this.sort = ArticlesFilter.Sort.All
//}.build())
//
////https://habr.com/kek/v2/articles/most-reading?fl=en%2Cru&page=1
//fun HabrahabrKekArticles.mostReading(page: Int) = filter(ArticlesFilterScope().apply {
//    this.page = page
//    this.sort = ArticlesFilter.Sort.MostReading
//}.build())
//
////https://habr.com/kek/v2/articles/?fl=en%2Cru&page=1&period=daily&sort=date
//fun HabrahabrKekArticles.top(period: ArticlesPeriod, page: Int) = filter(ArticlesFilterScope().apply {
//    this.page = page
//    this.sort = ArticlesFilter.Sort.Top(period)
//}.build())
//
////https://habr.com/kek/v2/articles/?news=true&fl=en%2Cru&hl=en&page=1
//fun HabrahabrKekArticles.news(page: Int) = filter(ArticlesFilterScope().apply {
//    this.page = page
//    this.sort = ArticlesFilter.Sort.News
//}.build())
//
////https://habr.com/kek/v2/articles/?query=latex&order=relevance&fl=en%2Cru&hl=en&page=1
//fun HabrahabrKekArticles.find(query: String, order: ArticlesOrder, page: Int) = filter(ArticlesFilterScope().apply {
//    this.page = page
//    this.sort = ArticlesFilter.Sort.Search(query, order)
//}.build())
