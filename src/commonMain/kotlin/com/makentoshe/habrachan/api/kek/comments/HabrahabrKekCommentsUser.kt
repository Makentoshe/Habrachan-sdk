package com.makentoshe.habrachan.api.kek.comments

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.api.common.ApiRequestIterable
import com.makentoshe.habrachan.api.common.comments.UserCommentsFilter
import com.makentoshe.habrachan.entity.UserLogin

fun HabrahabrKekComments.user(login: UserLogin, page: Int): HabrahabrKekCommentsUser {
    val filter = UserCommentsFilter(UserCommentsFilter.User(login.login), UserCommentsFilter.Page(page))
    return HabrahabrKekCommentsUser(path.append("/v2/users/").append(login.login).append("/comments"), filter)
}

data class HabrahabrKekCommentsUser internal constructor(
    override val path: CustomStringBuilder,
    internal val filter: UserCommentsFilter,
) : ApiRequestIterable {
    override val queries: Map<String, String> = HashMap<String, String>().apply {
        put(filter.user.key, filter.user.value)
        put(filter.page.key, filter.page.value.toString())
    }

    override fun page(value: Int): ApiRequestBuilder {
        return copy(path = path, filter = filter.copy(page = UserCommentsFilter.Page(value)))
    }

    override fun next(): ApiRequestIterable {
        return copy(path = path, filter = filter.copy(page = filter.page.copy(value = filter.page.value + 1)))
    }

    override fun previous(): ApiRequestIterable {
        return copy(path = path, filter = filter.copy(page = filter.page.copy(value = filter.page.value - 1)))

    }
}

