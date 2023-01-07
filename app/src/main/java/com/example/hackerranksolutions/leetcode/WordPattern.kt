package com.example.hackerranksolutions.leetcode

fun main() {
      println(wordPattern("abba", "dog cat cat dog"))
    println(
        wordPattern(
            "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd",
            "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"
        )
    )
}

fun wordPattern(pattern: String, s: String): Boolean {

    val checkHashMap = HashMap<Any, Any>()

    val words = s.split(" ".toRegex()).toTypedArray()
    if (words.size != pattern.length) return false
    for (i in words.indices) {
        val c = pattern[i]
        val w = words[i]
        if (!checkHashMap.containsKey(c)) checkHashMap[c] = i
        if (!checkHashMap.containsKey(w)) checkHashMap[w] = i
        if (checkHashMap[c] != checkHashMap[w]) return false
    }
    return true
}

