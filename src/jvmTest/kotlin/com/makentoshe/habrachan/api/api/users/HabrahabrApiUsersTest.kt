package com.makentoshe.habrachan.api.api.users

import com.makentoshe.habrachan.api.Habrahabr
import com.makentoshe.habrachan.api.api.HabrahabrApiTest
import com.makentoshe.habrachan.api.api.api
import com.makentoshe.habrachan.api.execute
import com.makentoshe.habrachan.entity.userlogin
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.http.HttpStatusCode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.runBlocking

class HabrahabrApiUsersTest: HabrahabrApiTest() {

    private val gateway = Habrahabr.api()
    private val httpClient = HttpClient(CIO)

    @Test
    fun `test should check get user info available`(): Unit = runBlocking {
        val request = gateway.users().user(userlogin("Makentoshe")).logoutbuild()
        assertEquals("https://habr.com/api/v1/users/Makentoshe", request.url)

        val response = request.execute(httpClient)
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun `test should check get user hubs and companies info available`(): Unit = runBlocking {
        val request = gateway.users().user(userlogin("Makentoshe")).hubsAndCompanies().logoutbuild()
        assertEquals("https://habr.com/api/v1/users/Makentoshe/hubs", request.url)

        val response = request.execute(httpClient)
        assertEquals(HttpStatusCode.OK, response.status)
    }
}
