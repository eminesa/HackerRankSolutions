package com.example.hackerranksolutions.leetcode

fun main() {
//println(removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4)))
    println(removeDuplicates(intArrayOf(1, 1, 2)))
}
/// I have an list include num caming from int they are positive 1,2,2,2,4,5,5,5,8,8,8,9

/// 1,2,4,5,8,9 return 6 num.size?

//have to create a hashmap may key is my int and value int if my hasmap contain the same key I will didn add If doesnt exist I will add?

fun removeDuplicates1(nums: IntArray): Int {

    if (nums.isEmpty()) return 0

    val distinctList: MutableList<Int> = ArrayList()
    for (number in nums) {
        if (!distinctList.contains(number)) {
            distinctList.add(number)
        }
    }

    return distinctList.size
}

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var i = 0
    for (j in 1 until nums.size) {
        if (nums[j] != nums[i]) {
            i++
            nums[i] = nums[j]
        }
    }
    return i + 1
}