package com.makentoshe.habrachan.api

import com.makentoshe.habrachan.api.common.ApiRequest
import com.makentoshe.habrachan.api.common.ApiRequestMethod
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.Url
import io.ktor.http.contentType

suspend fun ApiRequest.execute(client: HttpClient): HttpResponse {
    return client.request(Url(url)) {
        this@execute.queries.forEach { query -> parameter(query.key, query.value) }
        this@execute.headers.forEach { header -> headers.append(header.key, header.value) }

        this.method = defineMethod(this@execute.method).onPostPut {
            setBody(this@execute.body.string)
            contentType(ContentType.Application.FormUrlEncoded)
        }
    }
}

private fun defineMethod(method: ApiRequestMethod) = when (method) {
    is ApiRequestMethod.Get -> HttpMethod.Get
    is ApiRequestMethod.Put -> HttpMethod.Put
    is ApiRequestMethod.Post -> HttpMethod.Post
}

private fun HttpMethod.onPostPut(action: () -> Unit): HttpMethod {
    if (value == HttpMethod.Put.value || value == HttpMethod.Post.value) action()
    return this
}