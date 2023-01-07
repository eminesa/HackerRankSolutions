package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {
    println(missingElement(intArrayOf(4, 7, 9, 10), 1))
    println(missingElement(intArrayOf(4, 7, 9, 10), 3))
    println(missingElement(intArrayOf(1, 2, 4), 3))
}

fun missingElement1(nums: IntArray, k: Int): Int {

    Arrays.sort(nums)
    var firstElement = nums.first()
    val missingList: MutableList<Int> = ArrayList()

    while (missingList.size < k) {
        firstElement += 1
        if (!nums.contains(firstElement)) {
            missingList.add(firstElement)
        }
    }

    return missingList[k - 1]
}

fun missing(idx: Int, nums: IntArray): Int {
    return nums[idx] - nums[0] - idx
}

fun missingElement(nums: IntArray, k: Int): Int {
    val n = nums.size
    // If kth missing number is larger than
    // the last element of the array
    if (k > missing(n - 1, nums)) return nums[n - 1] + k - missing(n - 1, nums)
    var left = 0
    var right = n - 1
    var pivot: Int
    // find left = right index such that
    // missing(left - 1) < k <= missing(left)
    while (left != right) {
        pivot = left + (right - left) / 2
        if (missing(pivot, nums) < k) left = pivot + 1 else right = pivot
    }

    // kth missing number is greater than nums[idx - 1]
    // and less than nums[idx]
    return nums[left - 1] + k - missing(left - 1, nums)
}