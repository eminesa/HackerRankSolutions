package com.example.hackerranksolutions.leetcode

fun main() {
    println(canJump(intArrayOf(2, 3, 1, 1, 4)))
    println(canJump(intArrayOf(3, 2, 1, 0, 4)))
}

fun canJump(nums: IntArray): Boolean {
    var lastPos = nums.size - 1
    for (i in nums.indices.reversed()) {
        if (i + nums[i] >= lastPos) {
            lastPos = i
        }
    }
    return lastPos == 0
}
