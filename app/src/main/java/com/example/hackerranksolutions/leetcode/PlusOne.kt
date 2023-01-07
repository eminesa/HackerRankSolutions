package com.example.hackerranksolutions.leetcode

fun main() {
    val result = plusOne(intArrayOf(1, 2, 3))
    println(result.joinToString(", "))
}

fun plusOne1(digits: IntArray): IntArray {

    val currentString: StringBuilder = StringBuilder()
    val currentList: MutableList<Int> = ArrayList()
    digits.map { char ->
        currentString.append(char)
    }

    val sum = currentString.toString().toLong() + 1

    sum.toString().toList().map { intChar ->
        currentList.add(intChar.toString().toInt())
    }

    return currentList.toIntArray()
}

fun plusOne(digits: IntArray): IntArray {

    var digitList = digits
    val n = digitList.size

    // move along the input array starting from the end
    for (idx in n - 1 downTo 0) {
        // set all the nines at the end of array to zeros
        if (digitList[idx] == 9) {
            digitList[idx] = 0
        } else {
            // increase this rightmost not-nine by 1
            digitList[idx]++
            // and the job is done
            return digitList
        }
    }
    // we're here because all the digits are nines
    digitList = IntArray(n + 1)
    digitList[0] = 1
    return digitList
}