package com.example.hackerranksolutions.leet

import java.util.*

fun main() {
    println(minimumOperations(intArrayOf(1, 5, 0, 3, 5)))
    println(minimumOperations(intArrayOf(0)))
}

fun minimumOperations1(nums: IntArray): Int {

    if (nums.isEmpty()) return 0

    Arrays.sort(nums)
    var operation = 0

    for (i in nums.indices) {
        val minus = nums[i]
        if (minus > 0) {
            operation++
            for (index in nums.indices) {
                if (nums[index] > 0) {
                    nums[index] = nums[index] - minus
                }
            }
        }
    }

    return operation
}


fun minimumOperations123(nums: IntArray): Int {

    if (nums.isEmpty()) return 0

    Arrays.sort(nums)
    val  currentNums = nums.toMutableList()
    var operation = 0

    while (currentNums.isNotEmpty()){
        val minus = currentNums.first()
        if (minus == 0){
         currentNums.removeAt(0)
        }else{
            operation++
            for (index in currentNums.indices) {
                if (currentNums[index] > 0) {
                    currentNums[index] = currentNums[index] - minus
                }
            }
        }

    }

    return operation
}

fun minimumOperations(nums: IntArray): Int {

    //Set to hold unique elements of nums.
    val operationHashSet: MutableSet<Int> = HashSet()
    for (n in nums) {
        //Ignore 0.
        if (n == 0) continue

        //insert all non-zero elements to set.
        operationHashSet.add(n)
    }

    //Return size of set. which holds the unique elements.
    return operationHashSet.size
}