package com.example.hackerranksolutions.solutions

fun main() {
    println(findDigits(124))
}

fun findDigits(n: Int): Int {
    var r = n
    var count = 0

    while (r > 0) {
        if (r % 10 != 0 && n % (r % 10) == 0) count++
        r /= 10
    }

    return count
}