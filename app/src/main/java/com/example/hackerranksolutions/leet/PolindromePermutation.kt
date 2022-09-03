package com.example.hackerranksolutions.leet

import kotlin.math.absoluteValue

fun main() {
    println(canPermutePalindrome("aabbcd"))
    println(canPermutePalindrome("civic"))
    println(canPermutePalindrome("aca"))
    println(canPermutePalindrome("code"))
    println(canPermutePalindrome("aab"))
    println(canPermutePalindrome("aabaa"))
}

fun canPermutePalindrome(s: String): Boolean {
    if (s.isEmpty() || s.length < 2) return true

    val letterHashMap: HashMap<Char, Int> = HashMap()

    s.toCharArray().map {
        letterHashMap[it] = letterHashMap[it]?.plus(1) ?: 1
    }

    var isPair = 2
    letterHashMap.map {
        if (0 > isPair) {
            return false
        } else if (it.value % 2 == 1) {
            isPair -= 1
        }
    }
    return isPair >= 1
}

//it is a solution of a the string is palindrome?
fun isPalindrome(s: String): Boolean {
    if (s.isEmpty()) return true
    val size = s.length
    val medium = size / 2

    var index = 0
    while (index < medium) {

        if (s[index] == s[size - 1 - index])
            index++
        else return false

    }
    return true
}