package com.example.hackerranksolutions.leet

fun main() {
    println(longestPalindrome12("abccccdder"))
    println(longestPalindrome12("ccc"))
}

fun longestPalindrome12(s: String): Int {
    if (s.isEmpty()) return 0
    if (s.length < 2) return 1

    val letterHashMap: HashMap<Char, Int> = HashMap()

    s.toCharArray().map {
        letterHashMap[it] = letterHashMap[it]?.plus(1) ?: 1
    }

    var pairCounter = 0
    var oddCounter = 0
    letterHashMap.map {
        if (it.value % 2 == 0) {
            pairCounter += it.value

        } else {
            oddCounter += 1
            pairCounter += it.value - 1
        }
    }
    val result = if (oddCounter > 0) (1 + pairCounter) else pairCounter
    return result
}


fun longestPalindrome(s: String): Int {
    if (s.isEmpty()) return 0
    val set: MutableSet<Char> = HashSet()

    for (i in s.indices) {
        if (set.contains(s[i])) set.remove(s[i]) else set.add(s[i])
    }

    return if (set.size <= 1) s.length else s.length - set.size + 1
}
