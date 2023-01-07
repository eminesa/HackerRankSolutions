package com.example.hackerranksolutions.leetcode

fun main() {
    println(isPowerOfTwo(2))
    println(isPowerOfTwo(4))
    println(isPowerOfTwo(8))
    println(isPowerOfTwo(6))
}


fun isPowerOfTwo(n: Int): Boolean {
    var number = n
    if (number == 0) return false
    while (number % 2 == 0) {
        number /= 2
    }
    return number == 1
}