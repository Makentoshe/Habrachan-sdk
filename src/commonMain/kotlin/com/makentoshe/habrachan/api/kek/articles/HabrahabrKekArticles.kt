package com.makentoshe.habrachan.api.kek.articles

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiPath
import com.makentoshe.habrachan.api.kek.HabrahabrKekGateway

fun HabrahabrKekGateway.articles() = HabrahabrKekArticles(path.append("/v2/articles"))

data class HabrahabrKekArticles(override val path: CustomStringBuilder): ApiPath
