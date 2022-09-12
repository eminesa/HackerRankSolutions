package com.example.hackerranksolutions.leet

fun main() {
    println(divide(10, 3))
    println(divide(7, -3))
    println(divide(-7, -3))
    println(divide(-7, 3))

}

fun divide(dividend: Int, divisor: Int): Int {
    var currentDividend = dividend
    var currentDivisor = divisor
    var carryDivisor = 1
    var carryDivident = 1
    if (divisor < 0) {
        carryDivisor = -1
        currentDivisor *= carryDivisor
    }
    if (dividend < 0) {
        carryDivident = -1
        currentDividend *= carryDivident
    }

    var result = 0
    while (currentDividend >= currentDivisor) {
        currentDividend -= currentDivisor
        result += 1

    }

    result *= carryDivisor * carryDivident
    return if (result > Int.MAX_VALUE || result < Int.MIN_VALUE ) return 0 else result
}