package com.example.hackerranksolutions.leet

import java.util.*

fun main() {
    //val result = permute(intArrayOf(1, 2, 3))
    val result = permute(intArrayOf(1, 2, 3,4))
    //val result = permute(intArrayOf(0,1))
    println(result.joinToString("\n"))
}

fun permute1(nums: IntArray): List<List<Int>> {
    val permuteList: LinkedList<List<Int>> = LinkedList()

    for (i in nums.indices) {

        var repeat = nums.size - 1
        while (repeat > 0) {
            val list = LinkedList<Int>()
            list.add(nums[i])
            list.add(nums[repeat])

            var index = i
            while (index < repeat) {
                if (index != repeat && index != i) {
                    list.add(nums[index])
                }
                index++
            }
            permuteList.add(list)
            repeat--
        }

    }

    return permuteList.toList()
}

fun backtrack(
    n: Int,
    nums: ArrayList<Int?>?,
    output: MutableList<List<Int?>?>,
    first: Int
) {
    // if all integers are used up
    if (first == n) output.add(ArrayList(nums))
    for (i in first until n) {
        // place i-th integer first
        // in the current permutation
        Collections.swap(nums, first, i)
        // use next integers to complete the permutations
        backtrack(n, nums, output, first + 1)
        // backtrack
        Collections.swap(nums, first, i)
    }
}

fun permute(nums: IntArray): List<List<Int?>?> {
    // init output list
    val output: MutableList<List<Int?>?> = LinkedList()

    // convert nums into list since the output is a list of lists
    val nums_lst = ArrayList<Int?>()
    for (num in nums) nums_lst.add(num)
    val n = nums.size
    backtrack(n, nums_lst, output, 0)
    return output
}