package com.makentoshe.habrachan.api.kek.users

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.entity.UserLogin

fun HabrahabkKekUser.whois(): HabrahabrKekUserWhoIs {
    return HabrahabrKekUserWhoIs(path.append("/whois"), userlogin)
}

data class HabrahabrKekUserWhoIs internal constructor(
    override val path: CustomStringBuilder,
    internal val userlogin: UserLogin,
): ApiRequestBuilder
