package com.makentoshe.habrachan.api.api.articles

import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.api.common.ApiRequestMethod
import com.makentoshe.habrachan.api.common.articles.ArticleVote

fun HabrahabrApiArticleById.vote(vote: ArticleVote): HabrahabrApiArticlesVote {
    return HabrahabrApiArticlesVote(path.append("/vote"), vote)
}

data class HabrahabrApiArticlesVote(override val path: StringBuilder, val vote: ArticleVote) : ApiRequestBuilder {
    override val method: ApiRequestMethod = ApiRequestMethod.Put
    override val queries: Map<String, String> = HashMap<String, String>().apply {
        val value = when (vote) {
            is ArticleVote.Up -> 1
            is ArticleVote.Down -> -1
        }
        put("vote", value.toString())
    }
}