package com.example.hackerranksolutions.leetcode

fun main() {
    //println(findMedianSortedArrays(intArrayOf(), intArrayOf(1)))
    println(findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2, 7)))
}


fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var numsMedian = listOf<Int>()
    val num2Median = nums2.toMutableList()
    val numMedianToSet = mutableSetOf<Int>()
    when {

        nums1.isEmpty() -> numsMedian = nums2.toList()
        nums2.isEmpty() -> numsMedian = nums1.toList()
        nums1.isEmpty() && numsMedian.isEmpty() -> numsMedian = listOf()
        nums1[nums1.size - 1] <= nums2[0] -> numsMedian =
            nums1.toList() + nums2.toList()

        nums2[nums2.size - 1] <= nums1[0] -> numsMedian = nums2.toList() + nums1.toList()

        else -> {
            for (index in nums1.indices) {
                if (num2Median[0] <= nums1[index]) {
                    for (element in num2Median) {
                        numMedianToSet.add(element)
                        num2Median.remove(element)
                        if (num2Median.size > 0 && num2Median[0] > nums1[index]) {
                            numMedianToSet.add(nums1[index])
                        }
                        if (nums1.size-1 == index && num2Median.isNotEmpty()){
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

    return if (numsMedian.size % 2 == 1)
        numsMedian[numsMedian.size / 2].toDouble()
    else ((numsMedian[(numsMedian.size - 1) / 2].toDouble() + numsMedian[(numsMedian.size - 1) / 2 + 1].toDouble()) / 2.0)
}