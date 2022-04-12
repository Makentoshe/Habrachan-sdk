package com.makentoshe.habrachan.api.api.comments

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.api.HabrahabrApiGateway
import com.makentoshe.habrachan.api.common.ApiPath

//https://habr.com/api/v1/comments/133473?since=-1
fun HabrahabrApiGateway.comments(): HabrahabrApiComments {
    return HabrahabrApiComments(path)
}

data class HabrahabrApiComments internal constructor(
    override val path: CustomStringBuilder,
) : ApiPath