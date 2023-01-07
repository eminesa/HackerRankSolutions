package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {
    println(isAnagram("anagram", "nagaram"))
    println(isAnagram("ac", "bb"))
}

fun isAnagram12(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val tString = t.toCharArray().toMutableList()
    s.toCharArray().map { char ->
        if (tString.contains(char)) {
            tString.remove(char)
        }
    }

    return tString.isEmpty()
}

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }
    val str1 = s.toCharArray()
    val str2 = t.toCharArray()
    Arrays.sort(str1)
    Arrays.sort(str2)
    return Arrays.equals(str1, str2)
}