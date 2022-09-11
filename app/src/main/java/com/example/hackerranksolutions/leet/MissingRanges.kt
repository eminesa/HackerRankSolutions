package com.example.hackerranksolutions.leet

fun main() {
    val result = findMissingRanges(intArrayOf(0, 1, 3, 50, 75), 0, 99)
    //al result = findMissingRanges(intArrayOf(-1), -1, -1)
    println(result.joinToString("\n"))
}

fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<String> {

    if (nums.isEmpty()) {
        return if (lower == upper) {
            listOf(lower.toString())
        } else {
            listOf(lower.toString().plus("->").plus(upper))
        }
    }

    val missingRangeList: MutableList<String> = ArrayList()



    if (nums.first() != lower) {
        if (lower == nums.first() - 1) {
            missingRangeList.add(lower.toString())
        } else {
            missingRangeList.add((lower.toString().plus("->").plus(nums.first() - 1)))
        }
    }
    for (index in nums.indices) {

        if (index + 1 < nums.size) {
            if (nums[index] + 1 != nums[index + 1]) {

                val first = (nums[index] + 1)
                val last = nums[index + 1] - 1
                if (first == last) {
                    missingRangeList.add(
                        first.toString()
                    )
                } else {
                    missingRangeList.add(
                        first.toString().plus("->").plus(last)
                    )
                }
            }
        }

    }

    if (nums.last() != upper) {
        if (nums.last() + 1 == upper) {
            missingRangeList.add(((nums.last() + 1).toString()))
        } else {
            missingRangeList.add(((nums.last() + 1).toString().plus("->").plus(upper)))
        }
    }


    return missingRangeList
}