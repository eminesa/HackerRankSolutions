package com.example.hackerranksolutions.leetcode

fun main() {

    println(mySqrt(8))
    println(mySqrt(16))
    println(mySqrt(4))
    println(mySqrt(6))

}

// her durum icin gecerli değil
fun mySqrt1(x: Int): Int {

    if (x == 0) return 0
    var sqrt = 0
    var currentSqrt = sqrt * sqrt
    while (currentSqrt <= x) {
        sqrt += 1
        currentSqrt = (sqrt + 1) * (sqrt + 1)
    }

    return sqrt
}

fun mySqrt2(x: Int): Int {
    if (x < 2) return x
    val left = Math.pow(Math.E, 0.5 * Math.log(x.toDouble())).toInt()
    val right = left + 1
    return if (right.toLong() * right > x) left else right
}

fun mySqrt(x: Int): Int {
    if (x < 2) return x

    var num: Long
    var pivot: Int
    var left = 2
    var right = x / 2

    while (left <= right) {
        pivot = left + (right - left) / 2
        num = pivot.toLong() * pivot
        if (num > x) right = pivot - 1 else if (num < x) left = pivot + 1 else return pivot
    }
    return right
}