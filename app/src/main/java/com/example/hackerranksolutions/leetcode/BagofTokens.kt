package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {

    println(bagOfTokensScore(intArrayOf(100, 200, 300, 400), 200))
    println(bagOfTokensScore(intArrayOf(100, 200), 150))
}

fun bagOfTokensScore1(tokens: IntArray, power: Int): Int {

    if (tokens.isEmpty()) return 0
    val currentTokens: MutableList<Int> = tokens.toMutableList()
    var coin = 0

    for (index in tokens.indices) {
       val value = tokens[index]
     // if it is a game and play with two player I have to check is two player or not
    }
    return coin
}

fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
    var currentPower = power

    Arrays.sort(tokens)
    var lo = 0
    var hi = tokens.size - 1
    var points = 0
    var ans = 0
    while (lo <= hi && (currentPower >= tokens[lo] || points > 0)) {
        while (lo <= hi && currentPower >= tokens[lo]) {
            currentPower -= tokens[lo++]
            points++
        }
        ans = Math.max(ans, points)
        if (lo <= hi && points > 0) {
            currentPower += tokens[hi--]
            points--
        }
    }
    return ans
}
