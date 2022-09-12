package com.example.hackerranksolutions.leet

fun main() {
 // val result = intersect(intArrayOf(1,2,2,1), intArrayOf(2,2))
 val result = intersect(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4))
  println(result.joinToString(" "))
}

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {

    val intersectionList: MutableList<Int> = ArrayList()
    val currentMinList: MutableList<Int> =
        if (nums1.size <= nums2.size) nums1.toMutableList() else nums2.toMutableList()
    val currentMaxList: MutableList<Int> =
        if (nums1.size > nums2.size) nums1.toMutableList() else nums2.toMutableList()

    for (value in currentMinList) {
        if (currentMaxList.contains(value)) {
            intersectionList.add(value)
            currentMaxList.remove(value)
        }
    }

    return intersectionList.toIntArray()
}