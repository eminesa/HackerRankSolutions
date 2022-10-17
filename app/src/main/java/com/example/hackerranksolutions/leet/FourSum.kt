package com.example.hackerranksolutions.leet

import java.util.*

fun main() {

    val result = fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0)
    println(result.joinToString(" \n"))
}

fun fourSum12(nums: IntArray, target: Int): List<List<Int>> {

    if (nums.size < 4) return listOf()

    val fourSumList: MutableList<List<Int>> = ArrayList()

    for (index in nums.indices) { // 1,0,-1,0,-2,2 target = 0

        for (secondIndex in nums.indices) {

            if (secondIndex != index && secondIndex + 2 < nums.size) {
                val value =
                    nums[index] + nums[secondIndex] + nums[secondIndex + 1] + nums[secondIndex + 2]
                if (value == target) {
                    val list = IntArray(4)
                    list[0] = nums[index]
                    for ((trying, numberIndex) in (1 until  list.size).withIndex()) {
                        list[numberIndex] = nums[secondIndex + trying]
                    }
                    Arrays.sort(list)
                    fourSumList.add(list.toList())
                }
            }
        }

    }

    return fourSumList.toList()
}



    fun fourSum(nums: IntArray, target: Int): List<MutableList<Int>> {
        Arrays.sort(nums)
        return kSum(nums, target.toLong(), 0, 4)
    }

    fun kSum(nums: IntArray, target: Long, start: Int, k: Int): List<MutableList<Int>> {
        val res: MutableList<MutableList<Int>> = ArrayList()

        // If we have run out of numbers to add, return res.
        if (start == nums.size) {
            return res
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        val average_value = target / k

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (nums[start] > average_value || average_value > nums[nums.size - 1]) {
            return res
        }
        if (k == 2) {
            return twoSum(nums, target, start)
        }
        for (i in start until nums.size) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (subset in kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(ArrayList(Arrays.asList(nums[i])))
                    res[res.size - 1].addAll(subset)
                }
            }
        }
        return res
    }

    fun twoSum(nums: IntArray, target: Long, start: Int): List<MutableList<Int>> {
        val res: MutableList<MutableList<Int>> = ArrayList()
        var lo = start
        var hi = nums.size - 1
        while (lo < hi) {
            val currSum = nums[lo] + nums[hi]
            if (currSum < target || lo > start && nums[lo] == nums[lo - 1]) {
                ++lo
            } else if (currSum > target || hi < nums.size - 1 && nums[hi] == nums[hi + 1]) {
                --hi
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]))
            }
        }
        return res
    }
