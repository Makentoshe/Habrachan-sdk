@file: Suppress("ClassOrdering")

package com.makentoshe.habrachan

data class CustomStringBuilder constructor(private val list: ArrayList<String>) {

    constructor() : this(ArrayList())
    constructor(initial: String) : this(ArrayList<String>().apply { if (initial.isNotEmpty()) add(initial) })

    fun append(integer: Int) = append(integer.toString())

    fun append(string: String) = copy(list = list.copyAndAdd(string))

    fun dropLast() = copy(list = ArrayList(list).apply { removeLastOrNull() })

    override fun toString(): String {
        return list.joinToString(separator = "")
    }

    private fun appendCopying(string: String) = copy(list = list.copyAndAdd(string))
}

/** Copying current list and adds [strings] elements at the tail */
private fun ArrayList<String>.copyAndAdd(vararg strings: String) = ArrayList(this).apply { addAll(strings) }