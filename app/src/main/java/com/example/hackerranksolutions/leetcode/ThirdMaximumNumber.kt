package com.example.hackerranksolutions.leetcode

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    println(thirdMax(intArrayOf(1, 2)))
    println(thirdMax(intArrayOf(1, 2, 3)))
}

fun thirdMax(nums: IntArray): Int {
    // sort from bigger
    // add just unique numbers
    Arrays.sort(nums)
    val numberList: MutableList<Int> = ArrayList()
    nums.map {
        if (!numberList.contains(it)) {
            numberList.add(it)
        }
    }

    return if (numberList.size > 2) numberList[numberList.size - 3] else numberList.last()
}