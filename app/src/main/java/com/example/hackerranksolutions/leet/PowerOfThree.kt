package com.example.hackerranksolutions.leet

fun main() {
    println(isPowerOfThree(27))
    println(isPowerOfThree(9))
    println(isPowerOfThree(3))
    println(isPowerOfThree(5))
    println(isPowerOfThree(0))
    println(isPowerOfThree(-1))
    println(isPowerOfThree(1))
}

fun isPowerOfThree1(n: Int): Boolean { // Time Limit Exceeded Error

    if (n <= 0) return false
    if (n == 1) return true

    var currentValue = 3

    while (currentValue < n) {
        currentValue *= 3
    }

    return currentValue == n
}

fun isPowerOfThree(n: Int): Boolean {
    var currentn = n
    if (currentn < 1) {
        return false
    }
    while (currentn % 3 == 0) {
        currentn /= 3
    }
    return currentn == 1
}
