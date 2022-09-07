package com.example.hackerranksolutions.leet

fun main() {
    println(singleNumber(intArrayOf(2, 2, 1)))
    println(singleNumber(intArrayOf(4, 1, 2, 1, 2)))

}

fun singleNumber1(nums: IntArray): Int { // Hashmap solution

    val singleNumberHashMap: HashMap<Int, Int> = HashMap()
    for (index in nums.indices) {
        if (singleNumberHashMap.containsKey(nums[index])) {
            singleNumberHashMap.remove(nums[index])
        } else {
            singleNumberHashMap[nums[index]] = nums[index]
        }
    }
    singleNumberHashMap.map {
        return it.key
    }
    return 0
}

fun singleNumber(nums: IntArray): Int { // same but with list solution

    val singleNumberList: MutableList<Int> = ArrayList()
    for (index in nums.indices) {
        if (singleNumberList.contains(nums[index])) {
            singleNumberList.remove(nums[index])
        } else {
            singleNumberList.add(nums[index])
        }
    }

    return singleNumberList.first()
}