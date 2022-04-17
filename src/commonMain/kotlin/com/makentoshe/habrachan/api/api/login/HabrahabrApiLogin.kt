package com.makentoshe.habrachan.api.api.login

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.api.HabrahabrApiGateway
import com.makentoshe.habrachan.api.common.ApiPath

fun HabrahabrApiGateway.login() = HabrahabrApiLogin(path.dropLast().append("/auth"))

data class HabrahabrApiLogin internal constructor(override val path: CustomStringBuilder) : ApiPath