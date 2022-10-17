package com.example.hackerranksolutions.leet

fun main() {
    println(arrangeCoins(5))
    println(arrangeCoins(8))
}

fun arrangeCoins(n: Int): Int {
    var left: Long = 0
    var right = n.toLong()
    var k: Long
    var current: Long
    while (left <= right) {
        k = left + (right - left) / 2
        current = k * (k + 1) / 2
        if (current == n.toLong()) return k.toInt()
        if (n < current) {
            right = k - 1
        } else {
            left = k + 1
        }
    }
    return right.toInt()
}