package com.example.hackerranksolutions.leetcode

fun main() {
println(getMaximumGenerated(7))
println(getMaximumGenerated(2))
}

fun getMaximumGenerated(n: Int): Int {
    if (n == 0) {
        return 0
    }
    val nums = IntArray(n + 1)
    var maximumValue = 1
    nums[1] = 1
    for (i in 1..n) {
        if (i * 2 <= n) {
            nums[i * 2] = nums[i]
        }
        if (i * 2 + 1 <= n) {
            nums[i * 2 + 1] = nums[i] + nums[i + 1]
        }
        maximumValue = Math.max(maximumValue, nums[i])
    }
    return maximumValue
}
