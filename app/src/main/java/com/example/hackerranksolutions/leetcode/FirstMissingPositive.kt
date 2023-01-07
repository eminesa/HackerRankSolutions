package com.example.hackerranksolutions.leetcode

fun main() {
    println(firstMissingPositive(intArrayOf(1, 2, 0)))
    println(firstMissingPositive(intArrayOf(3,4,-1,1)))
    println(firstMissingPositive(intArrayOf(7,8,9,11,12)))
}

fun firstMissingPositive(nums: IntArray): Int {

    var index = 0
    while (index < nums.size) {
        if (!nums.contains(index + 1)) return index + 1
        index++
    }

    return nums.size + 1
}