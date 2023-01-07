package com.example.hackerranksolutions.leetcode

fun main() {
println(arithmeticTriplets(intArrayOf(0,1,4,6,7,10), 3))
println(arithmeticTriplets(intArrayOf(4,5,6,7,8,9), 2))
}

fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
    val size = nums.size
    var counter = 0
    for (i in 0 until size - 2) {

        for (j in i+1 until size - 1) {

            for (k in j+1 until size) {

                if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
                    counter++
                }

            }

        }

    }

    return counter
}