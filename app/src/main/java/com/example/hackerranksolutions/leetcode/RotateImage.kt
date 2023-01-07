package com.example.hackerranksolutions.leetcode

fun main() {
    rotate(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)))
}

fun rotate(matrix: Array<IntArray>): Unit {
    val matrixSize = matrix.size - 1
    val tempMatrix: MutableList<MutableList<Int>> = ArrayList()

    for (index in matrix.indices) {
        tempMatrix.add(matrix[index].toMutableList())
    }

    for (row in matrix.indices) {
        for (column in 0..matrixSize) {
            matrix[column][matrixSize - row] = tempMatrix[row][column]
        }
    }

}