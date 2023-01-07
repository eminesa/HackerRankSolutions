package com.example.hackerranksolutions.leetcode

fun main() {
    println(containsDuplicate(intArrayOf(1,2,3,1)))
}

fun containsDuplicate(nums: IntArray): Boolean {
    val numList:MutableList<Int> = ArrayList()
    for (element in nums){
        if (numList.contains(element)) return true
        else numList.add(element)
    }

    return false
}