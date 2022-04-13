package com.makentoshe.habrachan.entity

fun commentId(id: Int) = object : CommentId {
    override val commentId: Int = id
}

interface CommentId {
    val commentId: Int
}
