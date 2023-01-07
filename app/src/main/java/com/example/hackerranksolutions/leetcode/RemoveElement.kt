package com.example.hackerranksolutions.leetcode

fun main() {
    println(removeElement(intArrayOf(3, 2, 2, 3), 3))
    println(removeElement(intArrayOf(3, 2, 2, 3,4), 3))
}

fun removeElement1(nums: IntArray, `val`: Int): Int {
    var i = 0
    for (j in nums.indices) {
        if (nums[j] != `val`) {
            nums[i] = nums[j]
            i++
        }
    }
    return i
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var i = 0
    var n = nums.size
    while (i < n) {
        if (nums[i] == `val`) {
            nums[i] = nums[n - 1]
            // reduce array size by one
            n--
        } else {
            i++
        }
    }
    return n
}