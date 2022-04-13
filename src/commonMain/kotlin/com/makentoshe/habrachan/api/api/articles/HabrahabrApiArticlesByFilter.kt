@file: Suppress("ClassOrdering")

package com.makentoshe.habrachan.api.api.articles

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.api.articles.filter.ApiArticlesFilter
import com.makentoshe.habrachan.api.api.articles.filter.ApiArticlesFilterScope
import com.makentoshe.habrachan.api.api.articles.filter.ArticlesFlow
import com.makentoshe.habrachan.api.api.articles.filter.ArticlesOrder
import com.makentoshe.habrachan.api.api.articles.filter.ArticlesPeriod
import com.makentoshe.habrachan.api.common.ApiRequestBuilder

fun HabrahabrApiArticles.filter(filter: ApiArticlesFilterScope.() -> Unit): HabrahabrApiArticlesByFilter {
    return filter(ApiArticlesFilterScope().apply(filter).build())
}

fun HabrahabrApiArticles.filter(filter: ApiArticlesFilter): HabrahabrApiArticlesByFilter {
    return HabrahabrApiArticlesByFilter(path, filter)
}

data class HabrahabrApiArticlesByFilter(
    override val path: CustomStringBuilder,
    internal val filter: ApiArticlesFilter,
) : ApiRequestBuilder {

    override val queries: Map<String, String> = HashMap<String, String>().apply {
        filter.apply {
            putPageFilter(page)
            putIncludeFilter(include)
            putExcludeFilter(exclude)
            putSortFilter(sort)
        }
    }

    private fun HashMap<String, String>.putPageFilter(page: ApiArticlesFilter.Page) {
        put(page.key, page.value.toString())
    }

    private fun HashMap<String, String>.putIncludeFilter(include: ApiArticlesFilter.Include) {
        put("include", include.fields.joinToString(separator = ","))
    }

    private fun HashMap<String, String>.putExcludeFilter(exclude: ApiArticlesFilter.Exclude) {
        put("exclude", exclude.fields.joinToString(separator = ","))
    }

    private fun HashMap<String, String>.putSortFilter(sort: ApiArticlesFilter.Sort) {
        when (sort) {
            is ApiArticlesFilter.Sort.Feed -> path.append("/feed/all")

            is ApiArticlesFilter.Sort.All -> path.append("/posts/all")
            is ApiArticlesFilter.Sort.Interesting -> path.append("/posts/interesting")
            is ApiArticlesFilter.Sort.Top -> path.append("/top/${sort.periodString}")

            is ApiArticlesFilter.Sort.Flow -> path.append("/flows/${sort.flowString}")

            is ApiArticlesFilter.Sort.Hub.All -> path.append("/hub/${sort.title}/all")
            is ApiArticlesFilter.Sort.Hub.Interesting -> path.append("/hub/${sort.title}/interesting")

            is ApiArticlesFilter.Sort.User -> path.append("/users/${sort.login.login}/posts")
            is ApiArticlesFilter.Sort.Query -> {
                path.append("/search/posts/${sort.query}")
                putOrderFilter(sort.order)
            }
        }
    }

    private fun HashMap<String, String>.putOrderFilter(order: ArticlesOrder) {
        when (order) {
            is ArticlesOrder.Relevance -> put("sort", "relevance")
            is ArticlesOrder.Date -> put("sort", "date")
            is ArticlesOrder.Rating -> put("sort", "rating")
        }
    }

    private val ApiArticlesFilter.Sort.Top.periodString: String
        get() = when (period) {
            is ArticlesPeriod.Daily -> "daily"
            is ArticlesPeriod.Weekly -> "weekly"
            is ArticlesPeriod.Monthly -> "monthly"
            is ArticlesPeriod.Yearly -> "yearly"
            is ArticlesPeriod.Alltime -> "alltime"
        }

    private val ApiArticlesFilter.Sort.Flow.flowString: String
        get() = when (flow) {
            is ArticlesFlow.Develop -> "develop"
            is ArticlesFlow.Admin -> "admin"
            is ArticlesFlow.Design -> "design"
            is ArticlesFlow.Management -> "management"
            is ArticlesFlow.Marketing -> "marketing"
            is ArticlesFlow.PopSci -> "popsci"
        }
}
