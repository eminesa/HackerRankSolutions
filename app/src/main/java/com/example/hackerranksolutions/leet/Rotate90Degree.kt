package com.example.hackerranksolutions.leet
// JAVA Code for left Rotation of a matrix
// by 90 degree without using any extra space

fun main() {
    val arr = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12),
        intArrayOf(13, 14, 15, 16)
    )
    rotate90(arr)
    printMatrix(arr)

}

// After transpose we swap elements of
// column one by one for finding left
// rotation of matrix by 90 degree
private fun reverseColumns(arr: Array<IntArray>) {
    for (i in 0 until arr[0].size) {
        var j = 0
        var k: Int = arr[0].size - 1
        while (j < k) {
            val temp = arr[j][i]
            arr[j][i] = arr[k][i]
            arr[k][i] = temp
            j++
            k--
        }
    }
}

// Function for do transpose of matrix
private fun transpose(arr: Array<IntArray>) {
    for (i in arr.indices) { // start 0 to arr.size-1
        for (j in i until arr[0].size) {
            val temp = arr[j][i]
            arr[j][i] = arr[i][j]
            arr[i][j] = temp
        }
    }
}

// Function for print matrix
fun printMatrix(arr: Array<IntArray>) {
    for (i in arr.indices) {
        for (j in 0 until arr[0].size) print(arr[i][j].toString() + " ")
        println("")
    }
}

// Function to anticlockwise rotate
// matrix by 90 degree
fun rotate90(arr: Array<IntArray>) {
    transpose(arr)
    reverseColumns(arr)
}


