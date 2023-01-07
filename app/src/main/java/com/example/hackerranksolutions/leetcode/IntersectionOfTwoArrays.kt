package com.example.hackerranksolutions.leetcode

fun main() {
    val result = intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2))
    println(result.joinToString(", "))
}

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {

    if (nums1.isEmpty() || nums2.isEmpty()) return intArrayOf()

    var minList = nums1
    var maxList = nums2
    val intersectionList: HashSet<Int> = HashSet()

    if (nums1.size > nums2.size) {
        minList = nums2
        maxList = nums1
    }
    for (number in minList) {
        if (maxList.contains(number)) {
            intersectionList.add(number)
        }
    }
    return intersectionList.toIntArray()
}