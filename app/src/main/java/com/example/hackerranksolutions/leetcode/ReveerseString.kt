package com.example.hackerranksolutions.leetcode

fun main() {
    println(reverseString(charArrayOf('h', 'e', 'l', 'l', 'o')))
}

fun reverseString1(s: CharArray): Unit {

    for (index in s.size - 1 downTo 0) {
        println(s[index])
    }
}

fun reverseString(s: CharArray): Unit {
    var left = 0
    var right = s.size - 1
    while (left < right) {
        val currentLeft = s[left]
        s[left] = s[right]
        s[right] = currentLeft
        left++
        right--
    }
}