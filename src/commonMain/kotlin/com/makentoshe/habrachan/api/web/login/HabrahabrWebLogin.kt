package com.makentoshe.habrachan.api.web.login

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.api.web.HabrahabrWebGateway

fun HabrahabrWebGateway.login(): HabrahabrWebLogin {
    return HabrahabrWebLogin(CustomStringBuilder("https://account.habr.com").append("/login"))
}

data class HabrahabrWebLogin(override val path: CustomStringBuilder) : ApiRequestBuilder
