package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {
    println(canAttendMeetings(arrayOf(intArrayOf(0, 5), intArrayOf(5, 10), intArrayOf(15, 20))))
}

fun canAttendMeetings(intervals: Array<IntArray>): Boolean {

    Arrays.sort(intervals) { a, b -> Integer.compare(a.get(0), b.get(0)) }

    for (i in 0 until intervals.size - 1) {
        if (intervals[i][1] > intervals[i + 1][0]) {
            return false
        }
    }
    return true
}
