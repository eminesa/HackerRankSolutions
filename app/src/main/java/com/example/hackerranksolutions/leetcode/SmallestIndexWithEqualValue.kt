package com.example.hackerranksolutions.leetcode

fun main() {
    println(smallestEqual(intArrayOf(0, 1, 2, 3)))
    println(smallestEqual(intArrayOf(1,2,3,4,5,6,7,8,9,0)))
    println(smallestEqual(intArrayOf(7,8,3,5,2,6,3,1,1,4,5,4,8,7,2,0,9,9,0,5,7,1,6)))
}

fun smallestEqual(nums: IntArray): Int {

    for (index in nums.indices) {
      if (index == nums[index]){
          return index
      }
    }

    return -1
}