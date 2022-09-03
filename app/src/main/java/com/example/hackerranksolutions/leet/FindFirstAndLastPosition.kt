package com.example.hackerranksolutions.leet

fun main() {

    val result = searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8)
    println(result.joinToString(" "))
}

fun searchRange1233(nums: IntArray, target: Int): IntArray {
    val targerList: MutableList<Int> = ArrayList()

    val start = 0
    val end = nums.size - 1 // because of 0 index

    while (start <= end) {
        val medium = (start + (end - start)) / 2
        if (nums[medium] == target) {
            if (medium - 1 > start || nums[medium - 1] == target) {
                targerList.add(medium - 1)
                targerList.add(medium)
            }
        }
    }

    return targerList.toIntArray()
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf(-1, -1)

    var left = 0
    var right = nums.size

    while (left < right) {
        val mid = left + (right - left) / 2
        if (nums[mid] <= target) left = mid + 1 else right = mid
    }

    val end = left - 1
    if (end == -1 || nums[end] != target) return intArrayOf(-1, -1)
    left = 0
    right = nums.size - 1
    while (left < right) {
        val mid = left + (right - left) / 2
        if (nums[mid] < target) left = mid + 1 else right = mid
    }
    return intArrayOf(left, end)
}

