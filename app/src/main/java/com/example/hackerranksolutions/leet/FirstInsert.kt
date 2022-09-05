package com.example.hackerranksolutions.leet

fun main() {
    //[1,3,5,6]
    println(searchInsert(intArrayOf(1, 3, 4, 5, 6), 7))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 7))
    println(searchInsert(intArrayOf(1, 3, 4, 5, 6), 2))
    println(searchInsert(intArrayOf(1, 2, 3, 4, 5, 6), 2))
}

fun searchInsert(nums: IntArray, target: Int): Int {

    var start = 0
    var end = nums.size - 1

    while (start <= end) {

        val medium = start + (end - start) / 2

        if (nums[medium] == target) return medium

        if (nums[medium] < target) {
            start = medium + 1
        } else {
            end = medium - 1
        }
    }

    return start
}
