package com.example.hackerranksolutions.leet

fun main() {

}

fun maxSum(grid: Array<IntArray>): Int {
    var ans = 0
    for (i in 0 until grid.size - 2) {
        //Running the for loop for the row-2  times
        for (j in 0 until grid[0].size - 2) {
            //Running the inner for loop for the col-2  times
            val sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2]
            ans = Math.max(ans, sum)
        }
    }
    return ans
}
