package com.example.hackerranksolutions.leet

import java.util.*

fun main() {
  println(findTheDifference("", "t"))
  println(findTheDifference("abcd", "abcde"))
}

fun findTheDifference(s: String, t: String): Char {
    if (s.isEmpty()) return t.first()
    val sCharArray = s.toCharArray()
    val tCharArray = t.toCharArray()

    Arrays.sort(sCharArray)
    Arrays.sort(tCharArray)


    var index = 0
    while (index < s.length) {
        if (sCharArray[index] != tCharArray[index]) {
            return tCharArray[index]
        }
        index += 1
    }
    return tCharArray[index]
}