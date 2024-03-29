package com.example.hackerranksolutions.leetcode

import java.util.*
import kotlin.collections.HashMap

fun main() {
    println(longestStrChain(arrayOf("a", "ba", "bca", "bda", "bdca", "b")))
}

fun longestStrChain(words: Array<String>): Int {
    val dp: MutableMap<String, Int> = HashMap()

    // Sorting the list in terms of the word length.
    Arrays.sort(words) { a, b -> a.length - b.length }
    var longestWordSequenceLength = 1
    for (word in words) {
        var presentLength = 1
        // Find all possible predecessors for the current word by removing one letter at a time.
        for (i in word.indices) {
            val temp = StringBuilder(word)
            temp.deleteCharAt(i)
            val predecessor = temp.toString()
            val previousLength = dp.get(predecessor) ?: 0
            presentLength = Math.max(presentLength, previousLength + 1)
        }
        dp[word] = presentLength
        longestWordSequenceLength = Math.max(longestWordSequenceLength, presentLength)
    }
    return longestWordSequenceLength
}