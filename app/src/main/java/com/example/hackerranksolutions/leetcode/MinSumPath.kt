package com.example.hackerranksolutions.leetcode

fun main() {
    println(minPathSum(arrayOf(intArrayOf(1,3,1), intArrayOf(1,5,1), intArrayOf(4,2,1))))
}

fun minPathSum(grid: Array<IntArray>): Int {
    val row = grid.size
    val column: Int = grid[0].size
    var countRows = 0
    var countCols = 0

    while (countRows < row || countCols < column) {
        for (i in 0 until countRows) {
            insertMinSum(i, countCols, grid)
        }
        for (i in 0 until countCols) {
            insertMinSum(countRows, i, grid)
        }
        insertMinSum(countRows, countCols, grid)
        countCols++
        countRows++
    }

    return grid[row - 1][column - 1]
}

private fun insertMinSum(row: Int, col: Int, grid: Array<IntArray>) {
    if (cellExists(row, col, grid)) {
        if (cellExists(row - 1, col, grid) && cellExists(row, col - 1, grid)) {
            val `val` = grid[row][col]
            grid[row][col] = Math.min(grid[row - 1][col] + `val`, grid[row][col - 1] + `val`)
        } else if (cellExists(row - 1, col, grid)) {
            grid[row][col] += grid[row - 1][col]
        } else if (cellExists(row, col - 1, grid)) {
            grid[row][col] += grid[row][col - 1]
        }
    }
}

private fun cellExists(row: Int, col: Int, array: Array<IntArray>): Boolean {
    return row <= array.size - 1 && row >= 0 && col <= array[0].size - 1 && col >= 0
}