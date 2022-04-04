package com.makentoshe.habrachan.api.kek.articles

import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.api.common.ApiRequestMethod
import com.makentoshe.habrachan.api.common.articles.ArticleVote

fun HabrahabrKekArticleById.vote(vote: ArticleVote): HabrahabrApiArticlesVote {
    val value = when (vote) {
        is ArticleVote.Up -> "up"
        is ArticleVote.Down -> "down"
    }
    return HabrahabrApiArticlesVote(path.append("/votes/").append(value), vote)
}

data class HabrahabrApiArticlesVote(override val path: StringBuilder, val vote: ArticleVote) : ApiRequestBuilder {
    override val method: ApiRequestMethod = ApiRequestMethod.Post
    override val body: StringBuilder = StringBuilder("{}")
}