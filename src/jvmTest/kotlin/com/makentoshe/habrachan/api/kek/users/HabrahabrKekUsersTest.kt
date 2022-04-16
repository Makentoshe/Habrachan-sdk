package com.makentoshe.habrachan.api.kek.users

import com.makentoshe.habrachan.api.Habrahabr
import com.makentoshe.habrachan.api.api.api
import com.makentoshe.habrachan.api.common.build
import com.makentoshe.habrachan.api.execute
import com.makentoshe.habrachan.api.kek.HabrahabrKekGateway
import com.makentoshe.habrachan.api.kek.kek
import com.makentoshe.habrachan.api.kek.users.filter.UserSubscriptionsFilter
import com.makentoshe.habrachan.entity.userlogin
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.statement.request
import io.ktor.http.HttpStatusCode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.runBlocking

class HabrahabrKekUsersTest {

    private val gateway = Habrahabr.kek()
    private val httpClient = HttpClient(CIO)

    /** WhoIs contains main user information like */
    @Test
    fun `test should check get user whois info available`(): Unit = runBlocking {
        val request = gateway.users().user(userlogin("Makentoshe")).whois().build()
        assertEquals("https://habr.com/kek/v2/users/Makentoshe/whois", request.url)

        val response = request.execute(httpClient)
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun `test should check get user hubs info available`(): Unit = runBlocking {
        val request = gateway.users().user(userlogin("Makentoshe")).subscriptions {
            this.sort = UserSubscriptionsFilter.Sort.Hubs
        }.build()
        assertEquals("https://habr.com/kek/v2/users/Makentoshe/subscriptions/hubs", request.url)

        val response = request.execute(httpClient)
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun `test should check get user companies info available`(): Unit = runBlocking {
        val request = gateway.users().user(userlogin("Makentoshe")).subscriptions {
            this.sort = UserSubscriptionsFilter.Sort.Companies
        }.build()
        assertEquals("https://habr.com/kek/v2/users/Makentoshe/subscriptions/companies", request.url)

        val response = request.execute(httpClient)
        assertEquals(HttpStatusCode.OK, response.status)
    }

}