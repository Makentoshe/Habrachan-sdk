package com.makentoshe.habrachan.api.kek.users.filter

import com.makentoshe.habrachan.entity.UserLogin

class UserSubscriptionsFilterScope internal constructor(userlogin: UserLogin) {

    var page: UserSubscriptionsFilter.Page = UserSubscriptionsFilter.Page(1)
    var userlogin: UserSubscriptionsFilter.Userlogin = UserSubscriptionsFilter.Userlogin(userlogin.login)
    var sort: UserSubscriptionsFilter.Sort = UserSubscriptionsFilter.Sort.Companies

    internal fun build() = UserSubscriptionsFilter(page, userlogin, sort)
}