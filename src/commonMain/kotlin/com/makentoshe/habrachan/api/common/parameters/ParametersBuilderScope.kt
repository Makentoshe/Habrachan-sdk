package com.makentoshe.habrachan.api.common.parameters

open class ParametersBuilderScope {

    private val queries = HashMap<String, String>()
    private val headers = HashMap<String, String>()

    fun query(key: String, value: String) {
        queries[key] = value
    }

    fun header(key: String, value: String) {
        headers[key] = value
    }

    internal fun build() = Parameters(queries, headers)
}
