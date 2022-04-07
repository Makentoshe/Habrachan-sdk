package com.makentoshe.habrachan.api.kek.articles

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.api.articles.HabrahabrApiArticlesVote
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.api.common.ApiRequestMethod
import com.makentoshe.habrachan.api.common.articles.ArticleVote

fun HabrahabrKekArticleById.vote(vote: ArticleVote): HabrahabrKekArticlesVote {
    val value = when (vote) {
        is ArticleVote.Up -> "up"
        is ArticleVote.Down -> "down"
    }
    return HabrahabrKekArticlesVote(path.append("/votes/").append(value), vote)
}

data class HabrahabrKekArticlesVote(override val path: CustomStringBuilder, val vote: ArticleVote) : ApiRequestBuilder {
    override val method: ApiRequestMethod = ApiRequestMethod.Post
    override val body: StringBuilder = StringBuilder("{}")
}