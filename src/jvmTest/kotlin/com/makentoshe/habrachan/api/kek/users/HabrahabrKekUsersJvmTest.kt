package com.makentoshe.habrachan.api.kek.users

import com.makentoshe.habrachan.api.Habrahabr
import com.makentoshe.habrachan.api.common.build
import com.makentoshe.habrachan.api.execute
import com.makentoshe.habrachan.api.kek.kek
import com.makentoshe.habrachan.api.kek.users.filter.UserSubscriptionsFilter
import com.makentoshe.habrachan.entity.userlogin
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.http.HttpStatusCode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.runBlocking

class HabrahabrKekUsersJvmTest {

    private val gateway = Habrahabr.kek()
    private val httpClient = HttpClient(CIO)

    /** WhoIs contains main user information like */
    @Test
    fun `test should check get user whois info available`(): Unit = runBlocking {
        val response = gateway.users().user(userlogin("Makentoshe")).whois().build().execute(httpClient)
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun `test should check get user hubs info available`(): Unit = runBlocking {
        val response = gateway.users().user(userlogin("Makentoshe")).subscriptions {
            this.sort = UserSubscriptionsFilter.Sort.Hubs
        }.build().execute(httpClient)
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun `test should check get user companies info available`(): Unit = runBlocking {
        val response = gateway.users().user(userlogin("Makentoshe")).subscriptions {
            this.sort = UserSubscriptionsFilter.Sort.Companies
        }.build().execute(httpClient)
        assertEquals(HttpStatusCode.OK, response.status)
    }
}
