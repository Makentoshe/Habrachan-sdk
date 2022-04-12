package com.makentoshe.habrachan.api.api.comments

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.api.common.ApiRequestIterable
import com.makentoshe.habrachan.api.common.comments.UserCommentsFilter
import com.makentoshe.habrachan.api.kek.comments.HabrahabrKekCommentsUser
import com.makentoshe.habrachan.entity.UserLogin

fun HabrahabrApiComments.user(userlogin: UserLogin, page: Int): HabrahabrKekCommentsUser {
    val filter = UserCommentsFilter(UserCommentsFilter.User(userlogin.login), UserCommentsFilter.Page(page))
    return HabrahabrKekCommentsUser(path.append("/v1/users/").append(userlogin.login).append("/comments"), filter)
}

//https://habr.com/api/v1/users/Milfgard/posts
data class HabrahabrApiCommentsUser internal constructor(
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
