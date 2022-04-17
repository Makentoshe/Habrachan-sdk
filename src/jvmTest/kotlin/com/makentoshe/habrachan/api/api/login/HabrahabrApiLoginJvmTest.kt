package com.makentoshe.habrachan.api.api.login

import com.makentoshe.habrachan.api.Habrahabr
import com.makentoshe.habrachan.api.api.HabrahabrApiJvmTest
import com.makentoshe.habrachan.api.api.api
import com.makentoshe.habrachan.api.execute
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpRedirect
import io.ktor.http.HttpStatusCode
import kotlin.test.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class HabrahabrApiLoginJvmTest : HabrahabrApiJvmTest() {

    private val gateway = Habrahabr.api()
    private val httpClient = HttpClient(CIO) { install(HttpRedirect) { checkHttpMethod = false } }

    @Test
    fun `test should check user login by email and password available`(): Unit = runBlocking {
        val response = gateway.login().logpass(Logpass(email, password, client))
            .logoutbuild().execute(httpClient)
        assertEquals(HttpStatusCode.OK, response.status)
    }
}