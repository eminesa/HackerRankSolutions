package com.example.hackerranksolutions.leetcode

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    //println(findMedianSortedArrays(intArrayOf(), intArrayOf(1)))
    println(findMedianSortedArrays(intArrayOf(1,2,3), intArrayOf(4,5,6)))
    //println(findMedianSortedArrays(intArrayOf(3, 9, 19), intArrayOf(1, 2, 3, 4, 8, 9, 17)))
}

fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double {
    var numsMedian = listOf<Int>()
    val num2Median = nums2.toMutableList()
    val numMedianToSet = mutableSetOf<Int>()

    when {
        nums1.isEmpty() && nums2.isEmpty() -> return 0.0
        nums1.isEmpty() -> numsMedian = nums2.toList()
        nums2.isEmpty() -> numsMedian = nums1.toList()
        nums1.isEmpty() && numsMedian.isEmpty() -> numsMedian = listOf()
        else -> {
            for (index in nums1.indices) {
                if (num2Median[0] <= nums1[index]) {
                    for (element in num2Median) {
                        numMedianToSet.add(element)
                        num2Median.remove(element)
                        if (num2Median.size > 0 && num2Median[0] > nums1[index]) {
                            numMedianToSet.add(nums1[index])
                        }
                        if (nums1.size - 1 == index && num2Median.isNotEmpty()) {
                            num2Median.map {
                                numMedianToSet.add(it)
                            }
                        }
                    }
                } else {
                    numMedianToSet.add(nums1[index])
                }
            }
            numsMedian = numMedianToSet.toList()
        }
    }
    val numMedianSize = numsMedian.size
    val numMediumSize = (numMedianSize - 1) / 2

    return if (numMedianSize % 2 == 1) numsMedian[numMediumSize].toDouble()
    else ((numsMedian[numMediumSize].toDouble() + numsMedian[numMediumSize + 1].toDouble()) / 2.0)

}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val list: MutableList<Int> = ArrayList()

    for (a in nums1) list.add(a)
    for (a in nums2) list.add(a)
    list.sort()

    val numMedianSize = list.size
    val numMediumSize = (numMedianSize - 1) / 2
    return if (numMedianSize % 2 == 1) list[numMediumSize].toDouble()
    else ((list[numMediumSize].toDouble() + list[numMediumSize + 1].toDouble()) / 2.0)
}
