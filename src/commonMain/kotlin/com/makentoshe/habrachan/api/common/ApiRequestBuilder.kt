package com.makentoshe.habrachan.api.common

import com.makentoshe.habrachan.api.common.parameters.Parameters
import com.makentoshe.habrachan.api.common.parameters.ParametersBuilderScope

interface ApiRequestBuilder : ApiPath {
    val queries: Map<String, String> get() = emptyMap()
}

fun ApiRequestBuilder.build(parameters: Parameters, force: Boolean = true): ApiRequest {
    val requestQueries = HashMap(if (force) queries else parameters.queries)
    requestQueries.putAll(if (force) parameters.queries else queries)
    return ApiRequest(path.toString(), requestQueries, parameters.headers)
}

fun ApiRequestBuilder.build(force: Boolean = true, builder: ParametersBuilderScope.() -> Unit = {}): ApiRequest {
    return build(ParametersBuilderScope().apply(builder).build(), force)
}
