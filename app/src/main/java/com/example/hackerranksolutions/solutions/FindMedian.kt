package com.example.hackerranksolutions.solutions

import java.util.*

fun main() {
     print(findMedian(arrayOf(0, 1, 2, 4, 6, 5, 3)))
}


fun findMedian1(arr: Array<Int>): Int {

    val sortedArray = arr.sorted()
    var median = arr.size / 2

    median = if (sortedArray.size % 2 != 0) {
        sortedArray[median]
    } else {
        (sortedArray[median] +sortedArray[median+1]) / 2
    }
    return median

}


fun findMedian(arr: Array<Int>): Int {

    Arrays.sort(arr)
    var median = arr.size / 2

    median = if (arr.size % 2 != 0) {
        arr[median]
    } else {
        (arr[median] +arr[median+1]) / 2
    }
    return median

}