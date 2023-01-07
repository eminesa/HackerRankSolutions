package com.example.hackerranksolutions.leetcode


fun main() {
    println(myPow(2.00000, 10))
    println(myPow(2.10000, 3))
    println(myPow(0.00001, 3))
}

private fun fastPow(x: Double, n: Int): Double {
    if (n == 0) {
        return 1.0
    }
    val half = fastPow(x, n / 2)
    return if (n % 2 == 0) {
        half * half
    } else {
        half * half * x
    }
}

fun myPow(x: Double, n: Int): Double {
    var currentx = x
    var currentN = n
    if (currentN < 0) {
        currentx = 1 / x
        currentN = -currentN
    }
    return fastPow(currentx, currentN)
}
