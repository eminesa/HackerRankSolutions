package com.example.hackerranksolutions.leet

fun main() {
    println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
    //println(search(intArrayOf(4,5,6,7,0,1,2), 3))
}


fun search(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size - 1

    while (start <= end) {
        val mid = start + (end - start) / 2
        if (nums[mid] == target) return mid

        else if (nums[mid] >= nums[start]) {
            if (target >= nums[start] && target < nums[mid]) end = mid - 1 else start = mid + 1
        }
        else {
            if (target <= nums[end] && target > nums[mid]) start = mid + 1 else end = mid - 1
        }
    }

    return -1
}