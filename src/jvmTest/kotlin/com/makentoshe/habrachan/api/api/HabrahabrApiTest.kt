package com.makentoshe.habrachan.api

import com.makentoshe.habrachan.api.common.ApiRequest
import com.makentoshe.habrachan.api.common.ApiRequestBuilder
import com.makentoshe.habrachan.api.common.build
import com.makentoshe.habrachan.api.common.parameters.ParametersBuilderScope
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

/**
 * Here we require a Json file from resources which will contain user credentials.
 *
 * #/resources/credentials.json
 * {"api":"api","client":"client","token":"token"}
 */
@kotlinx.serialization.Serializable
data class HabrahabrApiCredentials(val api: String, val client: String, val token: String)

abstract class HabrahabrApiTest(jsonCredentialsFilepath: String = "credentials.json") {

    private val credentials = Json.decodeFromString<HabrahabrApiCredentials>(
        this::class.java.classLoader.getResource(jsonCredentialsFilepath).readText()
    )

    protected val client get() = credentials.client
    protected val api get() = credentials.api
    protected val token get() = credentials.token

    fun ApiRequestBuilder.logoutbuild(
        force: Boolean = true,
        builder: ParametersBuilderScope.() -> Unit = {},
    ): ApiRequest = build(ParametersBuilderScope().apply {
        header("client", client)
        header("apikey", api)
    }.apply(builder).build(), force)

    fun ApiRequestBuilder.loginbuild(
        force: Boolean = true,
        builder: ParametersBuilderScope.() -> Unit = {},
    ): ApiRequest = build(ParametersBuilderScope().apply {
        header("client", client)
        header("token", token)
    }.apply(builder).build(), force)
}
