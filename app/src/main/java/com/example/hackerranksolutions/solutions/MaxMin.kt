package com.example.hackerranksolutions.solutions

import java.util.*

fun main() {
    println(maxMin(2, arrayOf(1,4,7,2)))
    println(maxMin(4, arrayOf(1,2,3,4)))
}

fun maxMin(k: Int, arr: Array<Int>): Int {
    var min = 1000000000
    Arrays.sort(arr)
    for (i in 0 until arr.size - k + 1) {
        min = min.coerceAtMost(arr[i + k - 1] - arr[i])
    }
    return min
}