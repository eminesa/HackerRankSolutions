package com.example.hackerranksolutions.leetcode

fun main() {
    // ["ab", "a"] //
    // ["aaa","aa","aaa"]
    println(longestCommonPrefix(arrayOf("aaa", "aa", "")))
}

fun longestCommonPrefix(strs: Array<String>): String {

    // have to do flower list flow list and flight lsit and check is small length list
    val commonPrefix = StringBuilder()

    if (strs.isNotEmpty()) commonPrefix.append(strs.first())

    for (index in 1 until strs.size) {
        val prefixString = strs[index]

        if (prefixString.isEmpty()) return ""

        val minSizeList = if (commonPrefix.length <= prefixString.length) commonPrefix.length else prefixString.length
        val currentPrefix = StringBuilder()
        for (commonIndex in 0 until minSizeList) {
            if (prefixString[commonIndex] == commonPrefix[commonIndex]) {
                currentPrefix.append(prefixString[commonIndex])
                if (minSizeList - 1 == commonIndex) {
                    commonPrefix.clear()
                    commonPrefix.append(currentPrefix)
                }
            } else {
                if (currentPrefix.isEmpty()) {
                    return ""
                } else {
                    commonPrefix.clear()
                    commonPrefix.append(currentPrefix)
                }
                break
            }
        }
    }
    return commonPrefix.toString()
}