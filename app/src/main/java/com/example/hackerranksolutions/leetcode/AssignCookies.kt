package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {
    println(findContentChildren(intArrayOf(1, 2, 3), intArrayOf(1, 1)))
    println(findContentChildren(intArrayOf(1, 2), intArrayOf(1, 2, 3)))
}

fun findContentChildren(g: IntArray, s: IntArray): Int {
    Arrays.sort(g)
    Arrays.sort(s)
    var count = 0
    var i = g.size - 1
    var j = s.size - 1
    while (j >= 0 && i >= 0) {
        if (s[j] >= g[i]) {
            count++
            j--
        }
        i--
    }
    return count
}