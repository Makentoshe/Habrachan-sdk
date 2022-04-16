package com.makentoshe.api.kek.users

import com.makentoshe.habrachan.api.Habrahabr
import com.makentoshe.habrachan.api.common.ApiRequestMethod
import com.makentoshe.habrachan.api.common.build
import com.makentoshe.habrachan.api.kek.kek
import com.makentoshe.habrachan.api.kek.users.filter.UserSubscriptionsFilter
import com.makentoshe.habrachan.api.kek.users.subscriptions
import com.makentoshe.habrachan.api.kek.users.user
import com.makentoshe.habrachan.api.kek.users.users
import com.makentoshe.habrachan.api.kek.users.whois
import com.makentoshe.habrachan.entity.userlogin
import kotlin.test.Test
import kotlin.test.assertEquals

class HabrahabrKekUsersTest {

    private val gateway = Habrahabr.kek()

    /** WhoIs contains main user information like */
    @Test
    fun testShouldCheckGetUserWhoisInfoAvailable() {
        val request = gateway.users().user(userlogin("Makentoshe")).whois().build()
        assertEquals("https://habr.com/kek/v2/users/Makentoshe/whois", request.url)
        assertEquals(ApiRequestMethod.Get, request.method)
    }

    @Test
    fun testShouldCheckGetUserHubsInfoAvailable() {
        val request = gateway.users().user(userlogin("Makentoshe")).subscriptions {
            this.sort = UserSubscriptionsFilter.Sort.Hubs
        }.build()
        assertEquals("https://habr.com/kek/v2/users/Makentoshe/subscriptions/hubs", request.url)
        assertEquals(ApiRequestMethod.Get, request.method)
    }

    @Test
    fun testShouldCheckGetUserCompaniesInfoAvailable() {
        val request = gateway.users().user(userlogin("Makentoshe")).subscriptions {
            this.sort = UserSubscriptionsFilter.Sort.Companies
        }.build()
        assertEquals("https://habr.com/kek/v2/users/Makentoshe/subscriptions/companies", request.url)
        assertEquals(ApiRequestMethod.Get, request.method)
    }
}
