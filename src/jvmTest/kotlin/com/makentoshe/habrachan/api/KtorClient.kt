package com.makentoshe.habrachan.api

import com.makentoshe.habrachan.api.common.ApiRequest
import com.makentoshe.habrachan.api.common.ApiRequestMethod
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import io.ktor.http.Url

suspend fun ApiRequest.execute(client: HttpClient): HttpResponse {
    return client.request(Url(url)) {
        this.method = defineMethod(this@execute.method)
        this@execute.queries.forEach { query -> parameter(query.key, query.value) }
        this@execute.headers.forEach { header -> headers.append(header.key, header.value) }
    }
}

private fun defineMethod(method: ApiRequestMethod) = when (method) {
    is ApiRequestMethod.Get -> HttpMethod.Get
    is ApiRequestMethod.Put -> HttpMethod.Put
    is ApiRequestMethod.Post -> HttpMethod.Post
}
