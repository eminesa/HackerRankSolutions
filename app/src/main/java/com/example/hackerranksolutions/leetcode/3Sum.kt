package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {
    //  val result = threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
    // val result = threeSum(intArrayOf(-2, 0, 1, 1, 2))
    // val result = threeSum(intArrayOf(0,1,1))
    // val result = threeSum(intArrayOf(0, 1, 1))
    val result = threeSum(intArrayOf(-1, 0, 1, 0))
    println(result.joinToString("\n"))
}

fun threeSum(nums: IntArray): List<List<Int>> {

    if (nums.size < 3) return listOf()

    val ans: MutableSet<List<Int>> = HashSet()
    Arrays.sort(nums)
    val size = nums.size
    for (i in 0 until size) {

        var j = i + 1
        while (j < size) {

            var k = j + 1

            while (k < size) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    val list: MutableList<Int> = ArrayList()
                    list.add(nums[i])
                    list.add(nums[j])
                    list.add(nums[k])
                    ans.add(list)
                }

                k++
            }
            j++
        }
    }

    return ArrayList(ans)
}

fun threeSumadad(nums: IntArray): List<List<Int>> {
    val ans: MutableSet<List<Int>> = HashSet()
    Arrays.sort(nums)
    var i = 0
    var k = nums.size - 1
    var j = k - 1
    while (k >= 0) {
        if (i < j) {
            while (i < j && nums[i] + nums[j] < -nums[k]) {
                i++
            }
            while (i < j && nums[i] + nums[j] > -nums[k]) {
                j--
            }
            if (i < j && nums[i] + nums[j] == -nums[k]) {
                val list: MutableList<Int> = ArrayList()
                list.add(nums[i])
                list.add(nums[j])
                list.add(nums[k])
                ans.add(list)
                i = 0
                j--
            }
        } else {
            k--
            i = 0
            j = k - 1
        }
    }
    return ArrayList(ans)
}