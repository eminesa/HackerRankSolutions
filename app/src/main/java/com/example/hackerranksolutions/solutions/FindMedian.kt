package com.example.hackerranksolutions.solutions

fun main() {
     print(findMedian(arrayOf(0, 1, 2, 4, 6, 5, 3)))
}

fun findMedian(arr: Array<Int>): Int {

    val mArray = arr.sorted()
    val index = (arr.size/2)
    return mArray[index]
}