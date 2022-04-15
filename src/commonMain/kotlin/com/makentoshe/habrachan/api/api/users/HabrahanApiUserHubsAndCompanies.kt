package com.makentoshe.habrachan.api.api.users

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.entity.UserLogin

fun HabrahabrApiUser.hubsAndCompanies(): HabrahanApiUserHubsAndCompanies {
    return HabrahanApiUserHubsAndCompanies(path.append("/hubs"), userlogin)
}

data class HabrahanApiUserHubsAndCompanies internal constructor(
    override val path: CustomStringBuilder,
    internal val userlogin: UserLogin,
) : ApiRequestBuilder
