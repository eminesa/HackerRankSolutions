package com.example.hackerranksolutions.leet

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main() {
    //["Mary","John","Emma"], heights = [180,165,170]
    //val result = sortPeople(arrayOf("Mary", "John", "Emma"), intArrayOf(180, 165, 170))
    //Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
    val result = sortPeople(arrayOf("Alice", "Bob", "Bob"), intArrayOf(155, 185, 150))

    println(result.joinToString(", "))
}

fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {

    if (names.size < 2) return names

    val hashMap: HashMap<Int, String> = HashMap()

    for (index in names.indices) {
        hashMap[heights[index]] = names[index]
    }

    Arrays.sort(heights)
    val namesList: MutableList<String> = ArrayList()

    for (index in heights.size - 1 downTo 0) {
        hashMap[heights[index]]?.let { it1 -> namesList.add(it1) }
    }

    return namesList.toTypedArray()
}
