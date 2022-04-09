package com.makentoshe.habrachan.api.kek.articles.filter

class KekArticlesFilterScope internal constructor() {

    var page: KekArticlesFilter.Page = KekArticlesFilter.Page(1)
    var sort: KekArticlesFilter.Sort = KekArticlesFilter.Sort.None
    var user: KekArticlesFilter.User = KekArticlesFilter.User.None
    var flow: KekArticlesFilter.Flow = KekArticlesFilter.Flow.None
    var period: KekArticlesFilter.Period = KekArticlesFilter.Period.None
    var custom: KekArticlesFilter.Custom = KekArticlesFilter.Custom.None
    var score: KekArticlesFilter.Score = KekArticlesFilter.Score.None
    var flowNews: KekArticlesFilter.FlowNews = KekArticlesFilter.FlowNews.None
    var news: KekArticlesFilter.News = KekArticlesFilter.News.None
    var hub: KekArticlesFilter.Hub = KekArticlesFilter.Hub.None
    var query: KekArticlesFilter.Query = KekArticlesFilter.Query.None
    var order: KekArticlesFilter.Order = KekArticlesFilter.Order.None

    internal fun build(): KekArticlesFilter {
        return KekArticlesFilter(page, sort, user, flow, period, custom, score, flowNews, news, hub, query, order)
    }
}