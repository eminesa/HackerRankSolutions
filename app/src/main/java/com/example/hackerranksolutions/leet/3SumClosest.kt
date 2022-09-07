package com.example.hackerranksolutions.leet

import java.util.*

fun main() {
    println(threeSumClosest(intArrayOf(0, 2, -4, 3, 6, 7), 1))
}

fun threeSumClosest(nums: IntArray, target: Int): Int {
    var diff = Int.MAX_VALUE
    val sz = nums.size
    Arrays.sort(nums)
    var i = 0
    while (i < sz && diff != 0) {
        var lo = i + 1
        var hi = sz - 1
        while (lo < hi) {
            val sum = nums[i] + nums[lo] + nums[hi]
            if (Math.abs(target - sum) < Math.abs(diff)) {
                diff = target - sum
            }
            if (sum < target) {
                ++lo
            } else {
                --hi
            }
        }
        ++i
    }
    return target - diff
}
