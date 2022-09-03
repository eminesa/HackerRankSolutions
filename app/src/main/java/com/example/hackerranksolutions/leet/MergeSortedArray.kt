package com.example.hackerranksolutions.leet

fun main() {
    println(merge(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 4, 5), 3))
}

fun merge1(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {

    if (n == 0 && m == 0) return

    if (m == 0) return nums2.let {
        for (index in 0 until nums2.size - n) {
            println(nums2[index])
        }
    }
    if (n == 0) return nums1.let {
        for (index in 0 until nums1.size - m) {
            println(nums1[index])
        }
    }
    val mergedList: MutableList<Int> = ArrayList()
    if (m < n) {
        for (index in 0 until m) {
            if (nums1[index] <= nums2[index]) {
                mergedList.add(nums1[index])
                mergedList.add(nums2[index])
            } else {
                mergedList.add(nums2[index])
                mergedList.add(nums1[index])
            }
        }
        for (index in m until n) {
            mergedList.add(nums2[index])
        }
    }
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    // Set p1 and p2 to point to the end of their respective arrays.
    var p1 = m - 1
    var p2 = n - 1

    // And move p backwards through the array, each time writing
    // the smallest value pointed at by p1 or p2.
    val startSize = m + n - 1
    for (p in startSize downTo 0) {
        if (p2 < 0) {
            break
        }
        if (p1 >= 0 && nums1[p1] > nums2[p2]) {
            nums1[p] = nums1[p1--]
        } else {
            nums1[p] = nums2[p2--]
        }
    }
}
