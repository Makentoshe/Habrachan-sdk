package com.makentoshe.habrachan.api.kek.comments

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.entity.ArticleId

fun HabrahabrKekComments.article(id: ArticleId): HabrahabrKekCommentsArticle {
    return HabrahabrKekCommentsArticle(path.append("/v2/article/").append(id.articleId).append("/comments"))
}

data class HabrahabrKekCommentsArticle internal constructor(
    override val path: CustomStringBuilder,
) : ApiRequestBuilder