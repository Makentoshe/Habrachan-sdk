package com.makentoshe.habrachan.api.api.articles

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.entity.ArticleId

fun HabrahabrApiArticles.article(id: ArticleId): HabrahabrApiArticleById {
    return HabrahabrApiArticleById(path.append("/post/").append(id.articleId))
}

data class HabrahabrApiArticleById(override val path: CustomStringBuilder) : ApiRequestBuilder
