package com.makentoshe.habrachan.api.kek.users.filter

import com.makentoshe.habrachan.entity.UserLogin

data class UserSubscriptionsFilter(val page: Page, val login: Userlogin, val sort: Sort) {
    constructor(page: Int, login: UserLogin, sort: Sort) : this(Page(page), Userlogin(login.login), sort)

    data class Page(val value: Int)
    data class Userlogin(val login: String)
    sealed class Sort {
        object Companies : Sort()
        object Hubs : Sort()
    }
}
