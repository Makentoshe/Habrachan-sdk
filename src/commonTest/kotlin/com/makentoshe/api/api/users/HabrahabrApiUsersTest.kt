package com.makentoshe.api.api.users

import com.makentoshe.habrachan.api.Habrahabr
import com.makentoshe.habrachan.api.api.api
import com.makentoshe.habrachan.api.api.users.hubsAndCompanies
import com.makentoshe.habrachan.api.api.users.user
import com.makentoshe.habrachan.api.api.users.users
import com.makentoshe.habrachan.api.common.ApiRequestMethod
import com.makentoshe.habrachan.api.common.build
import com.makentoshe.habrachan.entity.userlogin
import kotlin.test.Test
import kotlin.test.assertEquals

class HabrahabrApiUsersTest {

    private val gateway = Habrahabr.api()
//    private val httpClient = HttpClient(CIO)

    @Test
    fun testShouldCheckGetUserInfoAvailable() {
        val request = gateway.users().user(userlogin("Makentoshe")).build()
        assertEquals("https://habr.com/api/v1/users/Makentoshe", request.url)
        assertEquals(ApiRequestMethod.Get, request.method)
    }

    @Test
    fun testShouldCheckGetUserHubsAndCompaniesInfoAvailable() {
        val request = gateway.users().user(userlogin("Makentoshe")).hubsAndCompanies().build()
        assertEquals("https://habr.com/api/v1/users/Makentoshe/hubs", request.url)
        assertEquals(ApiRequestMethod.Get, request.method)
    }
}
