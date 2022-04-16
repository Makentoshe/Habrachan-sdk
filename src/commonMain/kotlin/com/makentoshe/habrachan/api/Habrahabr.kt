package com.makentoshe.habrachan.api

import com.makentoshe.habrachan.CustomStringBuilder
import com.makentoshe.habrachan.api.common.ApiPath

object Habrahabr : ApiPath {
    override val path get() = CustomStringBuilder("https://habr.com")
}
