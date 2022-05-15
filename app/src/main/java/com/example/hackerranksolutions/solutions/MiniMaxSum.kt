package com.example.hackerranksolutions.solutions


fun main() {

    miniMaxSum(arrayOf(1,3,5,7,9))
    miniMaxSum1(arrayOf(1,3,5,7,9))

}

fun miniMaxSum(arr: Array<Int>): Unit {

    var min = Int.MAX_VALUE
    var max = 0
    var sum = 0

    for (number in arr) {
        sum += number
        if (number < min) min = number
        if (number > max) max = number
    }

    print("${sum - max} ${sum - min}")

}

fun miniMaxSum1(arr: Array<Int>): Unit {

    val sortedList = arr.sorted()

    val min = sortedList.first()
    val max = sortedList.last()

    val sum = arr.sumOf { it.toLong() }

    print("${sum-max} ${sum-min}" )

}