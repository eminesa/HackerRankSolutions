package com.example.hackerranksolutions.leetcode

import java.lang.StringBuilder

fun main() {
    val result =
        fullJustify(arrayOf("This", "is", "an", "example", "of", "text", "justification."), 16)

    println(result.joinToString(" \n"))
}

fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {

    val reCreateList = mutableListOf<String>()
    val maxString = StringBuilder()
    maxString.append(words.first().plus(" "))
    val calculateString = StringBuilder()
    calculateString.append(words.first())

    for (index in 1 until words.size) {
        calculateString.append(words[index].plus(" "))

        if (calculateString.length >= maxWidth) {
            reCreateList.add(maxString.toString())
            maxString.clear()
            calculateString.clear()
        }
        if (index != 0)
            maxString.append(words[index].plus(" "))
        if (index == words.size-1){
            reCreateList.add(maxString.toString())
        }
    }
    return reCreateList.toList()
}