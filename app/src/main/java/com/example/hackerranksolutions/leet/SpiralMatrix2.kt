package com.example.hackerranksolutions.leet

fun main() {

    generateMatrix(3)

}

fun generateMatrix(n: Int): Array<IntArray> {
    if (n == 0) return arrayOf()
    if (n == 1) return arrayOf(intArrayOf(1))

    val matrix = Array(n) {
        IntArray(
            n
        )
    }

    val maxLength = n * n
    var up = 0
    var left = 0
    var right = n - 1
    var down = n - 1
    var sizeIndex = 1

    while (sizeIndex <= maxLength) {

        // Traverse from left to right.
        for (col in left..right) {
            matrix[up][col] = sizeIndex
            sizeIndex += 1
        }
        // Traverse downwards.
        for (row in up + 1..down) {
            matrix[row][right] = sizeIndex
            sizeIndex += 1
        }
        // Make sure we are now on a different row.
        if (up != down) {
            // Traverse from right to left.
            for (col in right - 1 downTo left) {
                matrix[down][col] = sizeIndex
                sizeIndex += 1
            }
        }
        // Make sure we are now on a different column.
        if (left != right) {
            // Traverse upwards.
            for (row in down - 1 downTo up + 1) {
                matrix[row][left] = sizeIndex
                sizeIndex += 1
            }
        }
        left++
        right--
        up++
        down--
    }

    return matrix
}

class SolutionForSecond {
    var directions =
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))

    fun generateMatrix(n: Int): Array<IntArray> {
        val m = Array(n) {
            IntArray(
                n
            )
        }
        var row = 0
        var col = 0
        val centerRow = n / 2
        val centerCol = if (n % 2 == 0) n / 2 - 1 else n / 2
        var counter = 1
        m[row][col] = counter++
        var dirCount = 0
        var direction = directions[dirCount]
        while (!(row == centerRow && col == centerCol)) {
            if (cellExists(row + direction[0], col + direction[1], m)) {
                row += direction[0]
                col += direction[1]
                m[row][col] = counter++
            } else {
                dirCount++
                direction = directions[dirCount % 4]
            }
        }
        return m
    }

    private fun cellExists(row: Int, col: Int, m: Array<IntArray>): Boolean {
        return row >= 0 && row < m.size && col >= 0 && col < m[0].size && m[row][col] == 0
    }
}