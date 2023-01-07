package com.example.hackerranksolutions.leet

import java.util.*

fun main() {
println(findMaxK(intArrayOf(-1,10,6,7,-7,1)))
println(findMaxK(intArrayOf(-10,8,6,7,-2,-3)))
}

fun findMaxK(nums: IntArray): Int {

    var maxPositiveNumber = -1
    Arrays.sort(nums)
     val size = nums.size -1
    for (element in size downTo 0) {
        if (nums[element] > maxPositiveNumber && nums.contains(-nums[element])) {
            maxPositiveNumber = nums[element]
            break
        }
    }
    return maxPositiveNumber

}