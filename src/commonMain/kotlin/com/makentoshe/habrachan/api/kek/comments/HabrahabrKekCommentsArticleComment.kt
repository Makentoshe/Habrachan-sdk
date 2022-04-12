package com.makentoshe.habrachan.api.kek.comments

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiPath
import com.makentoshe.habrachan.entity.ArticleId
import com.makentoshe.habrachan.entity.CommentId

// https://habr.com/kek/v2/articles/660337/comments/24254855/votes
// {"value":1}
fun HabrahabrKekCommentsArticle.comment(id: CommentId): HabrahabrKekCommentsArticleComment {
    return HabrahabrKekCommentsArticleComment(path.append("/").append(id.commentId), articleId, id)
}

data class HabrahabrKekCommentsArticleComment internal constructor(
    override val path: CustomStringBuilder,
    internal val articleId: ArticleId,
    internal val commentId: CommentId,
) : ApiPath
