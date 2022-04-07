package com.makentoshe.habrachan.api.kek.articles

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.entity.ArticleId

fun HabrahabrKekArticles.article(id: ArticleId): HabrahabrKekArticleById {
    return HabrahabrKekArticleById(path.append("/").append(id.articleId))
}

data class HabrahabrKekArticleById(override val path: CustomStringBuilder) : ApiRequestBuilder
