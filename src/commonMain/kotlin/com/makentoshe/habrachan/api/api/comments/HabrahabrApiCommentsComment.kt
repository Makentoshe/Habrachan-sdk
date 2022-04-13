package com.makentoshe.habrachan.api.api.comments

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiPath
import com.makentoshe.habrachan.entity.CommentId

fun HabrahabrApiComments.comment(id: CommentId): HabrahabrApiCommentsComment {
    return HabrahabrApiCommentsComment(path.append("/v1/comments/").append(id.commentId), id)
}

data class HabrahabrApiCommentsComment internal constructor(
    override val path: CustomStringBuilder,
    internal val commentId: CommentId,
) : ApiPath
