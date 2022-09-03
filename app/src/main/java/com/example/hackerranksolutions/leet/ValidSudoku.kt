package com.example.hackerranksolutions.leet

fun main() {
    println(
        isValidSudoku(
            arrayOf(
                charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
            )
        )
    )
}

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val numberMatrix = 9

    // Use a binary number to record previous occurrence
    val rows = IntArray(numberMatrix)
    val cols = IntArray(numberMatrix)
    val boxes = IntArray(numberMatrix)

    for (row in 0 until numberMatrix) {
        for (column in 0 until numberMatrix) {
            // Check if the position is filled with number
            if (board[row][column] == '.') {
                continue
            }
            val content = board[row][column] - '0'
            val pos = 1 shl content - 1

            // Check the row
            if (rows[row] and pos > 0) {
                return false
            }
            rows[row] = rows[row] or pos

            // Check the column
            if (cols[column] and pos > 0) {
                return false
            }
            cols[column] = cols[column] or pos

            // Check the box
            val idx = row / 3 * 3 + column / 3
            if (boxes[idx] and pos > 0) {
                return false
            }
            boxes[idx] = boxes[idx] or pos
        }
    }
    return true
}
