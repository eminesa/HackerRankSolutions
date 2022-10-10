package com.example.hackerranksolutions.leet

fun main() {
    println(firstUniqChar("leetcode"))
    println(firstUniqChar("loveleetcode"))
    println(firstUniqChar("aabb"))
}

fun firstUniqChar(s: String): Int {
    if (s.isEmpty()) return -1
     val charList = s.toCharArray().toMutableList()

    for (index in s.indices) {
        val value = s[index]
        charList.removeAt(index)
        if (!charList.contains(value)) return index

        charList.add(index, value)
    }

    return -1
}