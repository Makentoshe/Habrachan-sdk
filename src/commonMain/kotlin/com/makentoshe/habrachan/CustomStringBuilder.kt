package com.makentoshe.habrachan

class CustomStringBuilder(initial: String) {

    private val list = ArrayList<String>()

    constructor() : this("")

    init {
        if (initial.isNotEmpty()) list.add(initial)
    }

    fun append(string: String) = this.apply { list.add(string) }

    fun append(integer: Int) = this.apply { list.add(integer.toString()) }

    fun dropLast() = this.apply { list.removeLastOrNull() }

    override fun toString(): String {
        return list.joinToString(separator = "")
    }

}