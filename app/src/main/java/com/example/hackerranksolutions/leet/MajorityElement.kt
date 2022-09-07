package com.example.hackerranksolutions.leet

fun main() {
    println(majorityElement(intArrayOf(3, 2, 3)))
    println(majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
    println(majorityElement(intArrayOf(8, 8, 7, 7, 7)))
}

fun majorityElement(nums: IntArray): Int {

    val majorityHashMap: HashMap<Int, Int> = HashMap()
    var majorityValue = nums.first()

    for (element in nums) {
        if (majorityHashMap.containsKey(element)) {
            majorityHashMap[element] = majorityHashMap[element]?.plus(1) ?: 0
            if (majorityHashMap[majorityValue] != null){
                if (majorityHashMap[element]!! > majorityHashMap[majorityValue]!!) {
                    majorityValue = element
                }
            }
        } else {
            majorityHashMap[element] = 1
        }
    }
    return majorityValue
}