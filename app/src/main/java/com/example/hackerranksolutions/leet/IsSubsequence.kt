package com.example.hackerranksolutions.leet

fun main() {
    println(isSubsequence("abc", "ahbgdc"))
    println(isSubsequence("acb", "ahbgdc"))
}

fun isSubsequence(s: String, t: String): Boolean {

    val currentS = StringBuilder(s)

    t.map {
        if (currentS.isEmpty()) return true
        if (currentS.first() == it) {
            val currentValue = currentS.removeRange(0, 1)
            currentS.clear()
            currentS.append(currentValue)
        }
    }

    return currentS.isEmpty()
}