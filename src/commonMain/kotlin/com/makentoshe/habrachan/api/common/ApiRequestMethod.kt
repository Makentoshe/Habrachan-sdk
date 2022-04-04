package com.makentoshe.habrachan.api.common

sealed class ApiRequestMethod {
    object Get : ApiRequestMethod()
    object Put : ApiRequestMethod()
    object Post : ApiRequestMethod()
}