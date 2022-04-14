package com.example.hackerranksolutions.solutionclass

import java.lang.Math.abs

fun main() {

    println(diagonalDifference(arrayOf(arrayOf(1, 23, 1), arrayOf(1, 3, 4), arrayOf(2, 4, 5))))

}

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    var diagonal1 = 0
    var diagonal2 = 0

    val n = arr.size

    for (i in 0 until n) {

        diagonal1 += arr[i][i]
        diagonal2 += arr[i][n - 1 - i]

    }

    return abs(diagonal1 - diagonal2)
}
