package com.makentoshe.habrachan.api.common

data class ApiRequest(val url: String, val queries: Map<String, String>, val headers: Map<String, String>)
