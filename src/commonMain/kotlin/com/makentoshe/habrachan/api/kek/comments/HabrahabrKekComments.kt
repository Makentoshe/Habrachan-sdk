package com.makentoshe.habrachan.api.kek.comments

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiPath
import com.makentoshe.habrachan.api.kek.HabrahabrKekGateway

fun HabrahabrKekGateway.comments() = HabrahabrKekComments(path)

data class HabrahabrKekComments internal constructor(
    override val path: CustomStringBuilder,
): ApiPath

