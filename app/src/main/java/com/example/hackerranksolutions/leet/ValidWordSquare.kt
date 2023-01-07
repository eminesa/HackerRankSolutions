package com.example.hackerranksolutions.leet

fun main() {
    println(validWordSquare(listOf("abcd", "bnrt", "cr", "dt")))
}

fun validWordSquare(words: List<String>?): Boolean {
    if (words == null || words.isEmpty()) {
        return true
    }
    val n = words.size
    for (i in words.indices) {
        for (j in 0 until words[i].length) {
            if (j >= n || words[j].length <= i || words[j][i] != words[i][j]) return false
        }
    }
    return true
}
