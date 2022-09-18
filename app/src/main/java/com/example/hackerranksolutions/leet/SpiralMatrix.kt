package com.example.hackerranksolutions.leet

fun main() {
    val result =
        spiralOrder(arrayOf(intArrayOf(1, 2, 3,4), intArrayOf( 5, 6,7,8), intArrayOf( 9,10,11,12), intArrayOf( 13,14,15,16)))
    println(result.joinToString(" "))
}

fun spiralOrder123(matrix: Array<IntArray>): List<Int> {
    // I have a matrix I want to
    val row = matrix.size
    val column = matrix[0].size
    val allSize = row * column
    val spiralList: MutableList<Int> = ArrayList()
    var topLine = 0
    var leftLine = 0
    var bottomLine = row - 1
    var rightLine = column - 1


    while (spiralList.size < allSize) {
        // first all time check top line
        for (index in leftLine..rightLine) {
            spiralList.add(matrix[topLine][index])
        }
        topLine += 1

        // right
        for (index in topLine until rightLine) { // last column is all time same
            spiralList.add(matrix[index][rightLine])
        }
        rightLine -= 1

        // bottomSide
        if (bottomLine > leftLine) {
            for (index in bottomLine downTo leftLine) {
                spiralList.add(matrix[bottomLine][index])
            }

        }
        bottomLine -= 1

        //left
        if (bottomLine >= topLine) {
            for (index in bottomLine downTo topLine) { // last column is all time same
                spiralList.add(matrix[index][leftLine])
            }
        }
        leftLine += 1

    }
    return spiralList.toList()
}

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val result: MutableList<Int> = ArrayList()
    val rows = matrix.size
    val columns: Int = matrix[0].size
    var up = 0
    var left = 0
    var right = columns - 1
    var down = rows - 1
    while (result.size < rows * columns) {
        // Traverse from left to right.
        for (col in left..right) {
            result.add(matrix[up][col])
        }
        // Traverse downwards.
        for (row in up + 1..down) {
            result.add(matrix[row][right])
        }
        // Make sure we are now on a different row.
        if (up != down) {
            // Traverse from right to left.
            for (col in right - 1 downTo left) {
                result.add(matrix[down][col])
            }
        }
        // Make sure we are now on a different column.
        if (left != right) {
            // Traverse upwards.
            for (row in down - 1 downTo up + 1) {
                result.add(matrix[row][left])
            }
        }
        left++
        right--
        up++
        down--
    }
    return result
}