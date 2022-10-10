package com.example.hackerranksolutions.leet

fun main() {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(maxSubArray(intArrayOf(-2, 1)))
    println(maxSubArray(intArrayOf(-2, 1, -3, 4)))
}

fun maxSubArray1(nums: IntArray): Int {
    var maxSubArray = Int.MIN_VALUE

    for (i in nums.indices) {
        var currentSubArray = 0

        for (j in i until nums.size) {
            currentSubArray += nums[j]
            maxSubArray = Math.max(maxSubArray, currentSubArray)
        }
    }
    return maxSubArray
} //Time Complexity: O(n^2)

fun maxSubArray(nums: IntArray): Int {
    // Initialize our variables using the first element.
    var currentSubArray = nums[0]
    var maxSubArray = nums[0]

    // Start with the 2nd element since we already used the first one.
    for (i in 1 until nums.size) {
        val num = nums[i]
        // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
        currentSubArray = Math.max(num, currentSubArray + num)
        maxSubArray = Math.max(maxSubArray, currentSubArray)
    }
    return maxSubArray
} //Time Complexity: O(n)


