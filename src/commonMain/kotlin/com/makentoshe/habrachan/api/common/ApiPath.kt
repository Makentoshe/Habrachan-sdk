package com.makentoshe.habrachan.api.common

import com.makentoshe.habrachan.CustomStringBuilder

interface ApiPath {
    /** Represents only url path, without queries and other stuff */
    val path: CustomStringBuilder
}

