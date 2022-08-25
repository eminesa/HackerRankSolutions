package com.example.hackerranksolutions.leet

fun main() {
    // ["X",".",".","X"],['.','.','.','X'],['.','.','.','X']
    println(
        countBattleships(
            arrayOf(
                charArrayOf('X', '.', 'X', 'X'),
                charArrayOf('.', '.', '.', 'X'),
                charArrayOf('.', '.', '.', 'X')
            )
        )
    )
}

fun countBattleships(board: Array<CharArray>): Int {
    var count = 0
    val m = board.size // get row
    val n: Int = board[0].size // get column
    for (i in 0 until m) {
        var j = 0
        while (j < n) {
            if (board[i][j] == 'X') { //if a hit
                count += 1
                board[i][j] = '.'
                if (j + 1 < n && board[i][j + 1] == 'X') { // horizontal
                    j += 1
                    while (j < n && board[i][j] == 'X') {
                        board[i][j] = '.'
                        j += 1
                    }
                } else if (i + 1 < m && board[i + 1][j] == 'X') { //vertically down
                    var temp = i + 1
                    while (temp < m && board[temp][j] == 'X') {
                        board[temp][j] = '.'
                        temp += 1
                    }
                }
                //size 1 so nothing
            }
            j++
        }
    }
    return count
}