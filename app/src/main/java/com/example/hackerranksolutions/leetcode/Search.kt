package com.example.hackerranksolutions.leetcode

fun main() {
     println(search12(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
     println(search12(intArrayOf(-1, 0, 3, 5, 9, 12), 0))
    println(search12(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
}

fun search12(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size - 1
    // this list is inorder list
    // so I can check half by half
    // this mean is I can -1, 3, 7,  8, 9 target = 9

    while (start <= end) {
        val medium = start + (end - start) / 2
        if (nums[medium] == target) return medium

        if (nums[medium] < target) {
            start = medium + 1

        } else {
            end = medium - 1
        }
    }

    return -1
}