package com.makentoshe.habrachan.api.api.articles

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.api.HabrahabrApiGateway
import com.makentoshe.habrachan.api.common.ApiPath

fun HabrahabrApiGateway.articles() = HabrahabrApiArticles(path.append("/v1"))

data class HabrahabrApiArticles(override val path: CustomStringBuilder): ApiPath
