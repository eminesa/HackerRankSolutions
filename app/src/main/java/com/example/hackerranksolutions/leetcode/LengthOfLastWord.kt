package com.example.hackerranksolutions.leetcode

fun main() {
    println(lengthOfLastWord("   fly me   to   the moon  "))
}

fun lengthOfLastWord12(s: String): Int {
    if (s.isEmpty()) return 0

    val listString = s.split(" ").toMutableList()

    while(listString.last().isEmpty()  || listString.last().isBlank()) {
        listString.removeAt(listString.size - 1)
    }

    return listString.last().length

}

fun lengthOfLastWord(s: String): Int {
    var p = s.length
    var length = 0
    while (p > 0) {
        p--
        // we're in the middle of the last word
        if (s[p] != ' ') {
            length++
        } else if (length > 0) {
            return length
        }
    }
    return length
}