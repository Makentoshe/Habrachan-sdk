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

//fun main() = runBlocking {
//    val request = Habrahabr.api().users().user(userlogin("Makentoshe")).hubsAndCompanies().build {
//////        query("fl", "en,ru")
////        header("csrf-token", "yQPemErn-hfu4eNj0Uv5fyU_PRZ7K-pWa-mQ")
////        header("Cookie", "connect_sid=s%3AKeBNhWmReiAtbgjzVmZa-CJbolAx-sTC.SPbf2YDDKB%2FW78fRP%2B%2F5wP64%2F8YlciA4xp2orxf32IY")
//        header("token", "ee828f6b64a066b352dc18e3034038c905c4d8ca")
//        header("client", "85cab69095196f3.89453480")
////////        header("apiKey", "173984950848a2d27c0cc1c76ccf3d6d3dc8255b")
//    }
////    println(request)
//    execute(request)
//}
//
//private suspend fun execute(request: ApiRequest) {
//    val response = HttpClient(CIO).request(Url(request.url)) {
//        method = defineMethod(request.method)
//        request.queries.forEach { query -> parameter(query.key, query.value) }
//        request.headers.forEach { header -> headers.append(header.key, header.value) }
//    }
//
//    println(response.call.request.content)
//    println(response.call.request.url)
//    println(response.body<String>())
//}
//
