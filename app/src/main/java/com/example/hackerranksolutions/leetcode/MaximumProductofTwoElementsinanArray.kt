package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {

    println(maxProduct(intArrayOf(3, 4, 5, 2)))
}

fun maxProduct1(nums: IntArray): Int {
    Arrays.sort(nums)
    val index = nums.size - 1
    return (nums[index] - 1) * (nums[index - 1] - 1)
}

fun maxProduct12(nums: IntArray): Int {

    val maxHashMap: HashMap<Int, Int> = HashMap()

    while (maxHashMap.size < 2) {
        var index = 0
        var maxElement = Int.MIN_VALUE
        for (i in nums.indices) {
            if (!maxHashMap.containsKey(i) && maxElement < nums[i]) {
                index = i
                maxElement = nums[i]
            }
        }
        maxHashMap[index] = maxElement
    }

    var multiply = 1

    for (map in maxHashMap) {
        multiply *= (map.value - 1)
    }
    return multiply
}

fun maxProduct(nums: IntArray): Int {
    val pq: PriorityQueue<Int> = PriorityQueue()
    for (i in 0..1) pq.add(nums[i])

    for (i in 2 until nums.size) {
        if (pq.peek() < nums[i]) {
            pq.poll()
            pq.add(nums[i])
        }
    }
    return (pq.poll() - 1) * (pq.poll() - 1)
}
