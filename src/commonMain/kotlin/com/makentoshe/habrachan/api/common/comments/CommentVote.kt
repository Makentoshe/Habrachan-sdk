package com.makentoshe.habrachan.api.common.comments

internal val CommentVote.value: Int
    get() = when (this) {
        is CommentVote.Up -> 1
        is CommentVote.Down -> -1
    }

sealed class CommentVote {
    object Up : CommentVote()
    object Down : CommentVote()
}
