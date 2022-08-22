package com.example.hackerranksolutions.solutions

fun main() {
    val result = rotateLeft(2, arrayOf(1, 2, 3, 4, 5))
    println(result.joinToString(" "))
}

fun rotateLeft(d: Int, arr: Array<Int>): Array<Int> {

    val leftSide = mutableListOf<Int>()
    val rightSide: MutableList<Int> = arr.toMutableList()

    for (leftIndex in 0 until d) {
        leftSide.add(arr[leftIndex])
        rightSide.add(leftSide[leftIndex])
        rightSide.removeAt(0)
    }

    return rightSide.toTypedArray()
}
