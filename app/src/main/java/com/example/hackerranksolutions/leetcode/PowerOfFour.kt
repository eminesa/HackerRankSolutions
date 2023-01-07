package com.example.hackerranksolutions.leetcode

fun main() {
    println(isPowerOfFour(16))
}

fun isPowerOfFour1(n: Int): Boolean {

    if (n == 0) {
        return false
    }
    var currentInt = n
    while (currentInt % 4 == 0) {
        currentInt /= 4
    }

    return currentInt == 1
}

fun isPowerOfFour(n: Int): Boolean {

    if (n >= 4 && n % 4 == 0) {
        isPowerOfFour(n / 4)
    }

    return n == 1
}

