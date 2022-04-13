package com.makentoshe.habrachan.api.common.articles

sealed class ArticleVote{
    object Up: ArticleVote()
    object Down: ArticleVote()
}
