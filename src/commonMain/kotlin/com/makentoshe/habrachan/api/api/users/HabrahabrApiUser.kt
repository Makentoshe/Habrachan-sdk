package com.makentoshe.habrachan.api.api.users

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.entity.UserLogin

fun HabrahabrApiUsers.user(userlogin: UserLogin) : HabrahabrApiUser {
    return HabrahabrApiUser(path.append("/").append(userlogin.login), userlogin)
}

class HabrahabrApiUser internal constructor(
    override val path: CustomStringBuilder,
    internal val userlogin: UserLogin,
) : ApiRequestBuilder