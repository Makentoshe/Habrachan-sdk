package com.makentoshe.habrachan.api.api.articles

import com.makentoshe.habrachan.api.common.ApiPath
import com.makentoshe.habrachan.api.common.ApiRequest
import com.makentoshe.habrachan.api.common.parameters.Parameters
import com.makentoshe.habrachan.api.common.parameters.ParametersBuilderScope
import com.makentoshe.habrachan.entity.ArticleId

fun HabrahabrApiArticles.article(id: ArticleId): HabrahabrApiArticleById {
    return HabrahabrApiArticleById(path.append("/post/").append(id.articleId))
}

data class HabrahabrApiArticleById(override val path: StringBuilder) : ApiPath



fun HabrahabrApiArticleById.build(parameters: Parameters): ApiRequest {
    return ApiRequest(path.toString(), parameters.queries, parameters.headers)
}

fun HabrahabrApiArticleById.build(builder: ParametersBuilderScope.() -> Unit): ApiRequest {
    return build(ParametersBuilderScope().apply(builder).build())
}
