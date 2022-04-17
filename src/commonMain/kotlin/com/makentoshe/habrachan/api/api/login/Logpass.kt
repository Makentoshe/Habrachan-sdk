package com.makentoshe.habrachan.api.api.login

data class Logpass(
    val email: String,
    val password: String,
    val client: String,
    val clientSecret: String = "41ce71d623e04eab2cb8c00cf36bc14ec3aaf6d3",
    val grantType: String = "password",
)