package com.makentoshe.habrachan.api.api

import com.makentoshe.habrachan.api.Habrahabr
import com.makentoshe.habrachan.api.common.ApiPath

fun Habrahabr.api() = HabrahabrApiGateway(path.append("/api"))

data class HabrahabrApiGateway(override val path: StringBuilder) : ApiPath
