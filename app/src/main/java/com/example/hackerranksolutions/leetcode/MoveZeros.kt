package com.example.hackerranksolutions.leetcode

fun main() {
    println(moveZeroes(intArrayOf(0, 1, 0, 3, 12)))
}
fun moveZeroes(nums: IntArray): Unit {

    val moveZeroList: MutableList<Int> = nums.toMutableList()
    var counter = nums.size - 1
    var index = 0
    while (index < counter) {

        if (moveZeroList[index] == 0) {
            moveZeroList.removeAt(index)
            moveZeroList.add(0)
            counter--
        } else {
            index++
        }
    }

    for (i in nums.indices) {
        nums[i] = moveZeroList[i]
    }
}