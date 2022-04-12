package com.makentoshe.habrachan.api.kek.comments

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.api.common.ApiRequestMethod
import com.makentoshe.habrachan.api.common.comments.CommentVote
import com.makentoshe.habrachan.api.common.comments.value
import com.makentoshe.habrachan.entity.ArticleId
import com.makentoshe.habrachan.entity.CommentId

fun HabrahabrKekCommentsArticleComment.vote(vote: CommentVote): HabrahabrKekCommentsArticleCommentVote {
    return HabrahabrKekCommentsArticleCommentVote(path.append("/votes"), articleId, commentId, vote)
}

data class HabrahabrKekCommentsArticleCommentVote internal constructor(
    override val path: CustomStringBuilder,
    internal val articleId: ArticleId,
    internal val commentId: CommentId,
    internal val vote: CommentVote,
) : ApiRequestBuilder {
    override val method = ApiRequestMethod.Post

    override val body = StringBuilder().append("{\"value\":${vote.value}}")
}
