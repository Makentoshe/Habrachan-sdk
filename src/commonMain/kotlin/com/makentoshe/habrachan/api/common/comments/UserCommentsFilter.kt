package com.makentoshe.habrachan.api.common.comments

data class UserCommentsFilter internal constructor(
    val user: User,
    val page: Page,
) {
    data class Page(val value: Int) {
        val key = "page"
    }
    data class User(val value: String) {
        val key = "user"
    }
}
