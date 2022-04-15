package com.makentoshe.habrachan.api.kek.users

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.api.common.ApiRequestIterable
import com.makentoshe.habrachan.api.kek.users.filter.UserSubscriptionsFilter
import com.makentoshe.habrachan.api.kek.users.filter.UserSubscriptionsFilterScope

fun HabrahabkKekUser.subscriptions(filter: UserSubscriptionsFilter): HabrahabrKekUserSubscriptions {
    val segment = when (filter.sort) {
        is UserSubscriptionsFilter.Sort.Companies -> "companies"
        is UserSubscriptionsFilter.Sort.Hubs -> "hubs"
    }

    return HabrahabrKekUserSubscriptions(path.append("/subscriptions/").append(segment), filter)
}

fun HabrahabkKekUser.subscriptions(builder: UserSubscriptionsFilterScope.() -> Unit): HabrahabrKekUserSubscriptions {
    return subscriptions(UserSubscriptionsFilterScope(userlogin).apply(builder).build())
}

data class HabrahabrKekUserSubscriptions internal constructor(
    override val path: CustomStringBuilder,
    internal val filter: UserSubscriptionsFilter,
) : ApiRequestIterable {
    override val queries: Map<String, String> = HashMap<String, String>().apply {
        put("page", filter.page.value.toString())
    }

    override fun page(value: Int): ApiRequestBuilder {
        return copy(path = path, filter = filter.copy(page = UserSubscriptionsFilter.Page(value)))
    }

    override fun next(): ApiRequestIterable {
        return copy(path = path, filter = filter.copy(page = UserSubscriptionsFilter.Page(filter.page.value + 1)))
    }

    override fun previous(): ApiRequestIterable {
        return copy(path = path, filter = filter.copy(page = UserSubscriptionsFilter.Page(filter.page.value - 1)))
    }
}