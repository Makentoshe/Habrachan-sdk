package com.makentoshe.habrachan.api.api.users

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.api.HabrahabrApiGateway
import com.makentoshe.habrachan.api.common.ApiPath

fun HabrahabrApiGateway.users() = HabrahabrApiUsers(path.append("/v1/users"))

data class HabrahabrApiUsers internal constructor(
    override val path: CustomStringBuilder,
): ApiPath
