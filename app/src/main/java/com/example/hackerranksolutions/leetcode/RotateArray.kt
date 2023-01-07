package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {

    //[1,2,3,4,5,6,7], k = 3
    println(rotate(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3))

}

fun rotate1(nums: IntArray, k: Int): Unit {
    Arrays.sort(nums)
    var counter = 0
    val numSize = nums.size
    val carry = k % numSize
    while (counter < carry) {
        var temporary = nums[numSize - 1]

        for (index in 0 until numSize) {
            val current = nums[index]
            nums[index] = temporary
            temporary = current
        }

        counter++
    }
}  // Time COmplexity: O(k*n)
// Space Complexity: O(1)

fun rotate12(nums: IntArray, k: Int) {
    val a = IntArray(nums.size)
    for (i in nums.indices) {
        a[(i + k) % nums.size] = nums[i]
    }
    for (i in nums.indices) {
        nums[i] = a[i]
    }
}// Time COmplexity: O(n)
// Space Complexity: O(n)

fun rotate(nums: IntArray, k: Int) {
    var count = 0
    var start = 0

    while (count < nums.size) {
        var current = start
        var prev = nums[start]
        do {
            val next = (current + k) % nums.size
            val temp = nums[next]
            nums[next] = prev
            prev = temp
            current = next
            count++
        } while (start != current)
        start++
    }
}
// Time COmplexity: O(n)
// Space Complexity: O(n)