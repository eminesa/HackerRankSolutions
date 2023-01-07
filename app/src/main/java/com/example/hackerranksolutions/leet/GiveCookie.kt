package com.example.hackerranksolutions.leet

fun main() {
    println(findContentChildren(intArrayOf(1, 2, 3), intArrayOf(1, 1)))
    println(findContentChildren(intArrayOf(1, 2), intArrayOf(1, 2, 3)))
}

fun findContentChildren12(g: IntArray, s: IntArray): Int {
    if (s.isEmpty()) return 0

    if (s.size <= g.size) return 1

    return if (s.size % g.size == 0) {
        s.size / g.size
    } else {
        (s.size / g.size) + 1
    }
}
