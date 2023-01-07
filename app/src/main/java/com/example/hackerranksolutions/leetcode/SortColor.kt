package com.example.hackerranksolutions.leetcode

fun main() {
    println(sortColors(intArrayOf(1, 0, 2, 2, 1)))
}

fun sortColors1(nums: IntArray) {
    // I have a list
    // I will create a new list

    if (nums.isEmpty()) return print("")
    val sortList: MutableList<Int> = ArrayList()
    var sortListCopy: MutableList<Int>
    sortList.add(nums.first())
    for (number in 1 until nums.size) {
        sortListCopy = sortList
        sortList.clear()
        for (index in sortListCopy.indices) {
            if (sortListCopy[index] <= number) {
                sortList.add(number)
                sortList.add(sortListCopy[index])
                break
            }

            sortList.add(sortListCopy[index])
        }
    }

}

fun sortColors2(nums: IntArray) {
    // I have a list
    // I will create a new list
    val hashmap: HashMap<Int, Int> = HashMap()

    nums.map {
        if (hashmap.containsKey(it)) {
            hashmap[it] = hashmap[it]?.plus(1) ?: 1
        } else {
            hashmap[it] = 1
        }
    }

    var index = 0

    while (index < nums.size) {
        var hashmapIndex = 0
        while (hashmapIndex < hashmap[index] ?: 0) {
            nums[index] = hashmap[index] ?: 0
            hashmapIndex += 1
            index += 1
        }

    }
}

fun sortColors(nums: IntArray) {
    // I have a list
    // I will create a new list
    for (index in nums.indices) {

        for (changeIndex in index + 1 until nums.size) {

            if (nums[changeIndex] < nums[index]) {
                val temporary = nums[index]
                nums[index] = nums[changeIndex]
                nums[changeIndex] = temporary
            }
        }
    }
}