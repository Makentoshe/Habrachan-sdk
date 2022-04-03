package com.makentoshe.habrachan.api.web

import com.makentoshe.habrachan.api.Habrahabr
import com.makentoshe.habrachan.api.common.ApiPath

fun Habrahabr.web() = HabrahabrWebGateway(path)

data class HabrahabrWebGateway(override val path: StringBuilder) : ApiPath
