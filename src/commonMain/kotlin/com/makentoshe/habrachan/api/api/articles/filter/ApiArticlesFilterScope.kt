package com.makentoshe.habrachan.api.api.articles.filter

class ApiArticlesFilterScope internal constructor() {

    var page: ApiArticlesFilter.Page = ApiArticlesFilter.Page(1)
    var include: ApiArticlesFilter.Include = ApiArticlesFilter.Include(emptyList())
    var exclude: ApiArticlesFilter.Exclude = ApiArticlesFilter.Exclude(emptyList())
    var sort: ApiArticlesFilter.Sort = ApiArticlesFilter.Sort.All

    internal fun build(): ApiArticlesFilter {
        return ApiArticlesFilter(sort, page, include, exclude)
    }
}
