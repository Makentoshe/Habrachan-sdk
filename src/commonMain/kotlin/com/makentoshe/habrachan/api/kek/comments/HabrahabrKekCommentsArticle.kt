package com.makentoshe.habrachan.api.kek.comments

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.entity.ArticleId

fun HabrahabrKekComments.article(id: ArticleId): HabrahabrKekCommentsArticle {
    return HabrahabrKekCommentsArticle(path.append("/v2/articles/").append(id.articleId).append("/comments"), id)
}

data class HabrahabrKekCommentsArticle internal constructor(
    override val path: CustomStringBuilder,
    internal val articleId: ArticleId,
) : ApiRequestBuilder
