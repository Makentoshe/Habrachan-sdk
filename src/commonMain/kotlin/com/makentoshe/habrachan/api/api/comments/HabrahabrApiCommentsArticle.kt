package com.makentoshe.habrachan.api.api.comments

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.entity.ArticleId

fun HabrahabrApiComments.article(id: ArticleId): HabrahabrApiCommentsArticle {
    return HabrahabrApiCommentsArticle(path.append("/v1/comments/").append(id.articleId))
}

data class HabrahabrApiCommentsArticle(override val path: CustomStringBuilder) : ApiRequestBuilder {
    override val queries: Map<String, String> = HashMap<String, String>().apply {
        put("since", "-1")
    }
}
