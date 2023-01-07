package com.example.hackerranksolutions.leetcode

fun main() {

    println(
        exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ), "ABCCED"
        )
    )

    println(
        exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ), "SEE"
        )
    )

    println(
        exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ), "ABCB" //"ABCESEEEFS"
        )
    )
}

fun exist(board: Array<CharArray>, word: String): Boolean {
    var row = 0
    var column = 0
    var currentWord = word
    // val visitedList: MutableList<List<Int>> = ArrayList()
    while (currentWord.isNotEmpty() && row < board.size && column < board[0].size) {

        if (board[row][column] == currentWord.first()) {
            // visitedList.add(listOf(row, column))
            currentWord = currentWord.removeRange(0, 1)

            if (currentWord.isEmpty()) return true

            if (column + 1 < board[0].size && board[row][column + 1] == currentWord.first()) {
                column += 1
            } else if (row + 1 < board.size && board[row + 1][column] == currentWord.first()) {
                row += 1
            } else if (column > 0 && board[row][column - 1] == currentWord.first()) {
                column -= 1
            } else if (row > 0 && board[row - 1][column] == currentWord.first()) {
                row -= 1
            } else {
                row += 1
            }
        } else {
            if (column < board[row].size - 1) {
                column += 1
            } else {
                column = 0
                row += 1
            }
        }
    }

    return currentWord.isEmpty()
}

