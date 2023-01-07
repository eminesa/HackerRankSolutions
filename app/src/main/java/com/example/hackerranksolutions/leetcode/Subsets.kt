package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {
    val result = subsets(intArrayOf(3,2,4,1))
    println(result.joinToString(" "))
}

fun subsets(nums: IntArray): List<List<Int?>?> {
    //final ans
    val res: MutableList<List<Int?>?> = ArrayList()
    //current subset
    val list: MutableList<Int?> = ArrayList()
    helper(0, nums, list, res)
    return res
}

//we can either pick the current element or not pick
fun helper(index: Int, nums: IntArray, list: MutableList<Int?>, res: MutableList<List<Int?>?>) {
    if (index >= nums.size) res.add(ArrayList(list)) else {
        //pick condition
        list.add(nums[index])
        helper(index + 1, nums, list, res)
        //backtracking to remove the last number
        list.removeAt(list.size - 1)
        //not pick condition
        helper(index + 1, nums, list, res)
    }
}

fun subsets12(nums: IntArray): List<List<Int>> {
    if (nums.isEmpty()) return emptyList()

    Arrays.sort(nums)
    val subSetList: MutableList<List<Int>> = ArrayList()
    subSetList.add(listOf())

    for (index in nums.indices) {
        val list: MutableList<Int> = ArrayList()
        list.add(nums[index])
        subSetList.add(listOf(nums[index]))
        for (jIndex in index + 1 until nums.size) {
            list.add(nums[jIndex])
            subSetList.add(list.toList())
        }
        val newList: MutableList<Int> = ArrayList()
        newList.add(nums[index])
        for (jIndex in index + 2 until nums.size) {
            newList.add(nums[jIndex])
            subSetList.add(newList.toList())
        }
    }

    return subSetList.toList()
}

fun subsets1(nums: IntArray): List<List<Int>> {

    val output: MutableList<List<Int>> = ArrayList()
    val n = nums.size

    for (i in Math.pow(2.0, n.toDouble()).toInt() until Math.pow(2.0, (n + 1).toDouble())
        .toInt()) {
        // generate bitmask, from 0..00 to 1..11
        val bitmask = Integer.toBinaryString(i).substring(1)

        // append subset corresponding to that bitmask
        val curr: MutableList<Int> = ArrayList()
        for (j in 0 until n) {
            if (bitmask[j] == '1') curr.add(nums[j])
        }
        output.add(curr)
    }
    return output
}

