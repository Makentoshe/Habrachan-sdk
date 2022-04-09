package com.makentoshe.habrachan.api.common.flows

sealed class ArticlesFlow {
    object Feed : ArticlesFlow()

    object AllStreams : ArticlesFlow()
    object Development : ArticlesFlow()
    object Admin : ArticlesFlow()
    object Design : ArticlesFlow()
    object Management : ArticlesFlow()
    object Marketing : ArticlesFlow()
    object PopSci : ArticlesFlow()
}
