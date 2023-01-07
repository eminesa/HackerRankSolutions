package com.example.hackerranksolutions.leetcode

import java.util.*


fun main() {
    println(checkInclusion("ab", "eidbaooo"))
}

fun checkInclusion1(s1: String, s2: String): Boolean { //inclusion = dahil etme
    // I have two string
    /// I will check in the second string contain or not contain the string
    val inclusionlist: MutableList<String> = ArrayList()
    val stack: Stack<Char> = Stack()
    val reverseString = StringBuilder()
    val stringBuilder = StringBuilder()

    for (letter in s1) {
        stack.add(letter)
    }

    while (stack.isNotEmpty()) {
        reverseString.append(stack.pop())
    }

    for (index in s2.indices) {
        stringBuilder.append(s2[index])
        inclusionlist.add(stringBuilder.toString())
        if (inclusionlist.contains(reverseString.toString()) || inclusionlist.contains(s1)) {
            return true
        }
        for (j in index + 1 until s2.length) {
            stringBuilder.append(s2[j])
            inclusionlist.add(stringBuilder.toString())
            if (inclusionlist.contains(reverseString.toString()) || inclusionlist.contains(s1)) {
                return true
            }
        }
        stringBuilder.clear()
    }

    return false
}

fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.length > s2.length) return false
    val s1map = IntArray(26)
    val s2map = IntArray(26)
    for (i in s1.indices) {
        s1map[s1[i] - 'a']++
        s2map[s2[i] - 'a']++
    }
    var count = 0
    for (i in 0..25) {
        if (s1map[i] == s2map[i]) count++
    }
    for (i in 0 until s2.length - s1.length) {
        val r = s2[i + s1.length] - 'a'
        val l = s2[i] - 'a'
        if (count == 26) return true
        s2map[r]++
        if (s2map[r] == s1map[r]) {
            count++
        } else if (s2map[r] == s1map[r] + 1) {
            count--
        }
        s2map[l]--
        if (s2map[l] == s1map[l]) {
            count++
        } else if (s2map[l] == s1map[l] - 1) {
            count--
        }
    }
    return count == 26
}