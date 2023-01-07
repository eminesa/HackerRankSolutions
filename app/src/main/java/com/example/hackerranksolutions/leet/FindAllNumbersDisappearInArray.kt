package com.example.hackerranksolutions.leet

fun main() {
    println(findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
    println(findDisappearedNumbers(intArrayOf(1,1)))
}

fun findDisappearedNumbers(nums: IntArray): List<Int> {

    val disappearList: MutableList<Int> = ArrayList()

    for (index in nums.indices) {

        if (!nums.contains(index + 1)) {
            disappearList.add(index + 1)
        }
    }

    return disappearList
}