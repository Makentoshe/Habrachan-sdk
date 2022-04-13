package com.makentoshe.habrachan.entity

fun userlogin(string: String) = object : UserLogin {
    override val login: String = string
}

interface UserLogin {
    val login: String
}
