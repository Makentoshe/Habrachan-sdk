package com.makentoshe.habrachan.api.api.comments

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.api.common.ApiRequestMethod
import com.makentoshe.habrachan.api.common.comments.CommentVote
import com.makentoshe.habrachan.api.common.comments.value
import com.makentoshe.habrachan.entity.CommentId

fun HabrahabrApiCommentsComment.vote(vote: CommentVote): HabrahabrApiCommentsCommentVote {
    return HabrahabrApiCommentsCommentVote(path.append("/vote"), commentId, vote)
}

data class HabrahabrApiCommentsCommentVote internal constructor(
    override val path: CustomStringBuilder,
    internal val commentId: CommentId,
    internal val vote: CommentVote,
) : ApiRequestBuilder {
    override val method: ApiRequestMethod = ApiRequestMethod.Put

    override val queries: Map<String, String> = HashMap<String, String>().apply {
        put("vote", vote.value.toString())
    }
}
