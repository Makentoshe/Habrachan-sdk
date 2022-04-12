package com.makentoshe.habrachan.api.common

data class ApiRequest(
    val method: ApiRequestMethod,
    val url: String,
    val queries: Map<String, String>,
    val headers: Map<String, String>,
    val body: Body,
) {
    data class Body(val string: String)
}
