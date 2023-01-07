package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {
    val result = answerQueries(intArrayOf(4, 5, 2, 1), intArrayOf(3, 10, 21))
    println(result.joinToString(" "))
}

fun answerQueries12(nums: IntArray, queries: IntArray): IntArray {

    val answerList: MutableList<Int> = ArrayList()
    Arrays.sort(nums)
    for (element in queries) {
        var temporary = 0
        val list: MutableList<Int> = ArrayList()
        for (number in nums) {
            if (temporary == element) {
                break
            }
            if (number == element && temporary == 0) {
                list.add(number)
                break
            } else if (number < element) {
                temporary += number
                list.add(number)
            }

        }
        answerList.add(list.size)
    }

    return answerList.toIntArray()
}

fun answerQueries(nums: IntArray, queries: IntArray): IntArray {
    // Get the prefix sum array of the sorted 'nums'.
    Arrays.sort(nums)
    for (i in 1 until nums.size) nums[i] += nums[i - 1]

    // For each query, find its insertion index to the prefix sum array.
    val n = queries.size
    val answer = IntArray(n)
    for (i in 0 until n) {
        val index = binarySearch(nums, queries[i])
        answer[i] = index
    }
    return answer
}

fun binarySearch(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left < right) {
        val mid = (left + right) / 2
        if (nums[mid] == target) return mid + 1
        if (nums[mid] < target) left = mid + 1 else right = mid - 1
    }
    return if (nums[left] > target) left else left + 1
}