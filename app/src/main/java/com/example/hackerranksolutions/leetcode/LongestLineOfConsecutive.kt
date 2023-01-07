package com.example.hackerranksolutions.leetcode

fun main() {
    println(longestLine(arrayOf(intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 0, 0, 1))))
}

fun longestLine(mat: Array<IntArray>): Int {

    if (mat.isEmpty()) return 0

    var ones = 0
    // horizontal
    for (i in mat.indices) {
        var count = 0
        for (j in 0 until mat[0].size) {
            if (mat[i][j] == 1) {
                count++
                ones = Math.max(ones, count)
            } else count = 0
        }
    }
    // vertical
    for (i in 0 until mat[0].size) {
        var count = 0
        for (j in mat.indices) {
            if (mat[j][i] == 1) {
                count++
                ones = Math.max(ones, count)
            } else count = 0
        }
    }
    // upper diagonal
    run {
        var i = 0
        while (i < mat[0].size || i < mat.size) {
            var count = 0
            var x = 0
            var y = i
            while (x < mat.size && y < mat[0].size) {
                if (mat[x][y] == 1) {
                    count++
                    ones = Math.max(ones, count)
                } else count = 0
                x++
                y++
            }
            i++
        }
    }
    // lower diagonal
    run {
        var i = 0
        while (i < mat[0].size || i < mat.size) {
            var count = 0
            var x = i
            var y = 0
            while (x < mat.size && y < mat[0].size) {
                if (mat[x][y] == 1) {
                    count++
                    ones = Math.max(ones, count)
                } else count = 0
                x++
                y++
            }
            i++
        }
    }
    // upper anti-diagonal
    run {
        var i = 0
        while (i < mat[0].size || i < mat.size) {
            var count = 0
            var x = 0
            var y: Int = mat[0].size - i - 1
            while (x < mat.size && y >= 0) {
                if (mat[x][y] == 1) {
                    count++
                    ones = Math.max(ones, count)
                } else count = 0
                x++
                y--
            }
            i++
        }
    }
    // lower anti-diagonal
    var i = 0
    while (i < mat[0].size || i < mat.size) {
        var count = 0
        var x = i
        var y: Int = mat[0].size - 1
        while (x < mat.size && y >= 0) {

            // System.out.println(x+" "+y);
            if (mat[x][y] == 1) {
                count++
                ones = Math.max(ones, count)
            } else count = 0
            x++
            y--
        }
        i++
    }
    return ones
}