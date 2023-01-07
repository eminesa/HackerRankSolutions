package com.example.hackerranksolutions.leetcode

fun main() {
    val result = summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9))
    println(result.joinToString("\n"))
}

fun summaryRanges(nums: IntArray): List<String> {
    // initial like Arraylist() faster than mutableList<String>()
    val summary: MutableList<String> = ArrayList()
    var total: Int // bir deger tanimlayinca time complexity cok fark edecek sekilde artıyor.
    var index = 0
// start zero

    while (index < nums.size) {
        total = index
        // try to extend the range [nums[i], nums[j]]
        while (index + 1 < nums.size && nums[index + 1] == nums[index] + 1) {
            ++index
        }
        // put the range into the list
        if (total == index) {
            summary.add(nums[total].toString())
        } else {
            summary.add(nums[total].toString() + "->" + nums[index])
        }
        ++index
    }

    return summary
}
