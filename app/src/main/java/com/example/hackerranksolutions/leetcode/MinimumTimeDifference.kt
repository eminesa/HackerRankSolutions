package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {
    println(findMinDifference(listOf("00:00", "23:30","00:12")))
}

fun findMinDifference(timePoints: List<String>): Int {

    val arr = IntArray(timePoints.size)
    for (i in timePoints.indices) {
        val time = timePoints[i].split(":")
        arr[i] = time[0].toInt() * 60 + time[1].toInt() // elimde dakikalar var artık
    }

    Arrays.sort(arr)
    var min = arr[0] + 24 * 60 - arr[timePoints.size - 1]
    for (i in 1 until timePoints.size) {
        min = Math.min(min, arr[i] - arr[i - 1])
    }
    return min
}
