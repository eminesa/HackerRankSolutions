package com.example.hackerranksolutions.solutions

fun main() {

    println(solve(arrayOf(1, 1, 2, 4, 2)))

}

fun solve(arr: Array<Int>): Long {

    var availablePairValue = 0L
    var maxValue = 0

    for (index in arr.indices) {
        for (jIndex in arr.indices) {
            maxValue = when {
                arr[index] > arr[jIndex] -> {
                    arr[index]
                }
                else -> {
                    arr[jIndex]
                }
            }
            if (arr[index].times(arr[jIndex]) <= maxValue && index < jIndex) {
                availablePairValue += 1
            }
        }
    }

    return availablePairValue
}
