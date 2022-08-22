package com.example.hackerranksolutions.leet

fun isPowerOfTwo(n: Int): Boolean {
    var number = n
    if (number == 0) return false
    while (number % 4 == 0) {
        number /= 4
    }
    return number == 1
}