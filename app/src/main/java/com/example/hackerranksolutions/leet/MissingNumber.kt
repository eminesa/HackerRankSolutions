package com.example.hackerranksolutions.leet

import java.util.*

fun main() {
    println(missingNumber(intArrayOf(3, 0, 1)))
    println(missingNumber(intArrayOf(3, 0, 2)))
    println(missingNumber(intArrayOf(0, 1)))
    println(missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
}

fun missingNumber(nums: IntArray): Int {
    Arrays.sort(nums)
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        if (!nums.contains(left)) return left
        if (!nums.contains(right)) return right
        left++
        right--
    }

    return nums.last() + 1
}
// Time Complexity(n/2)
// space complecity O(1)