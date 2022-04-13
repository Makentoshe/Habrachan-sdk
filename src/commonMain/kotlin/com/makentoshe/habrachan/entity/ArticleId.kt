package com.makentoshe.habrachan.entity

fun articleId(id: Int) = object : ArticleId {
    override val articleId: Int = id
}

interface ArticleId {
    val articleId: Int
}
