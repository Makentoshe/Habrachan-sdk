package com.makentoshe.habrachan.api.kek

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.Habrahabr
import com.makentoshe.habrachan.api.common.ApiPath

fun Habrahabr.kek() = HabrahabrKekGateway(path.append("/kek"))

data class HabrahabrKekGateway(override val path: CustomStringBuilder) : ApiPath
