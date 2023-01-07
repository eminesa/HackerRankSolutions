package com.example.hackerranksolutions.leetcode

fun main() {
    // println(strStr("sadbutsad", "sad"))
    // println(strStr("leetcode", "leeto"))
    println(strStr("mississippi", "issip"))
}

fun strStr(haystack: String, needle: String): Int {

    if (haystack.isEmpty() || !haystack.contains(needle)) return -1
    var currentNeedle = StringBuilder(needle)

    for (index in haystack.indices) {
        // set needle string when came back again
        currentNeedle.clear()
        currentNeedle.append(needle)

        if (currentNeedle.first() == haystack[index]) {
            // add while and
            currentNeedle = currentNeedle.removeRange(0, 1) as StringBuilder
            // use while in this section
            for (currentIndex in index until haystack.length - 1){

            }
        }

        if (currentNeedle.isEmpty()) return index - (needle.length - 1)
    }

    return -1
}