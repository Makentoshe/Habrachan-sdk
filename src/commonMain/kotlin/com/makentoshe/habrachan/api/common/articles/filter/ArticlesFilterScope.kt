package com.makentoshe.habrachan.api.common.articles.filter

class ArticlesFilterScope internal constructor(){

    var sort: ArticlesFilter.Sort = ArticlesFilter.Sort.All

    private var internalPage = 1
    var page: Int
        get() = internalPage
        set(value) = if (value > 0) internalPage = value else throw IllegalArgumentException("Page should be positive")

    internal fun build(): ArticlesFilter {
        return ArticlesFilter(ArticlesFilter.Page(internalPage), sort)
    }
}