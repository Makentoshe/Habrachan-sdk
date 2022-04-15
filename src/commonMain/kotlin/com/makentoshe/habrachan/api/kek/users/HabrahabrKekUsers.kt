package com.makentoshe.habrachan.api.kek.users

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiPath
import com.makentoshe.habrachan.api.kek.HabrahabrKekGateway

fun HabrahabrKekGateway.users(): HabrahabrKekUsers {
    return HabrahabrKekUsers(path)
}

data class HabrahabrKekUsers internal constructor(
    override val path: CustomStringBuilder,
) : ApiPath
