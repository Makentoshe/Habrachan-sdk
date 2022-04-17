package com.makentoshe.habrachan.api.api.login

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.api.common.ApiRequestMethod

fun HabrahabrApiLogin.logpass(logpass: Logpass): HabrahabrApiLoginLogpass {
    return HabrahabrApiLoginLogpass(path.append("/o/access-token"), logpass)
}

data class HabrahabrApiLoginLogpass internal constructor(
    override val path: CustomStringBuilder,
    internal val logpass: Logpass,
) : ApiRequestBuilder {
    override val method = ApiRequestMethod.Post
    override val body = StringBuilder().apply {
        append("email=").append(logpass.email).append("&")
        append("password=").append(logpass.password).append("&")
        append("client_id=").append(logpass.client).append("&")
        append("grant_type=").append(logpass.grantType).append("&")
        append("client_secret=").append(logpass.clientSecret)
    }
}

