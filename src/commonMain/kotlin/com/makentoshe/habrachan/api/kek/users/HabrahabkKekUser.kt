package com.makentoshe.habrachan.api.kek.users

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiPath
import com.makentoshe.habrachan.entity.UserLogin

fun HabrahabrKekUsers.user(userlogin: UserLogin): HabrahabkKekUser {
    return HabrahabkKekUser(path.append("/v2/users/").append(userlogin.login), userlogin)
}

data class HabrahabkKekUser internal constructor(
    override val path: CustomStringBuilder,
    internal val userlogin: UserLogin,
) : ApiPath
