package com.example.hackerranksolutions.leet

import java.util.*
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashSet

fun main() {
    println(
        maxAreaOfIsland(
            arrayOf(
                intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
                intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
                intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
            )
        )
    )
}

fun maxAreaOfIsland12(grid: Array<IntArray>): Int {
    //0 and 1 binary matrix
    //neighboard check is 1 if one they have connect

    val containOneInCellHashMap: HashSet<List<Int>> = LinkedHashSet()
    var maxArea = 0
    for (row in grid.indices) {
        for (column in 0 until grid[row].size) {

            if (grid[row][column] == 1) {
                containOneInCellHashMap.add(listOf(row, column))
            }
        }
    }

    while (containOneInCellHashMap.isNotEmpty()) {
        val element = containOneInCellHashMap.elementAt(0)
        var row = element[0]
        var column = element[1]
        maxArea += 1
        while (containOneInCellHashMap.contains(listOf(row, column))) {
            containOneInCellHashMap.remove(listOf(row, column))
            column += 1
            while (containOneInCellHashMap.contains(listOf(row, column))) {
                containOneInCellHashMap.remove(listOf(row, column))
                column += 1
            }
            row += 1
            column = element[1]
        }

    }
    return maxArea
}

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    val seen = Array(grid.size) {
        BooleanArray(
            grid[0].size
        )
    }
    val dr = intArrayOf(1, -1, 0, 0)
    val dc = intArrayOf(0, 0, 1, -1)
    var ans = 0
    for (r0 in grid.indices) {
        for (c0 in 0 until grid[0].size) {
            if (grid[r0][c0] == 1 && !seen[r0][c0]) {
                var shape = 0
                val stack: Stack<IntArray> = Stack()
                stack.push(intArrayOf(r0, c0))
                seen[r0][c0] = true
                while (!stack.empty()) {
                    val node: IntArray = stack.pop()
                    val r = node[0]
                    val c = node[1]
                    shape++
                    for (k in 0..3) {
                        val nr = r + dr[k]
                        val nc = c + dc[k]
                        if (0 <= nr && nr < grid.size && 0 <= nc && nc < grid[0].size && grid[nr][nc] == 1 && !seen[nr][nc]
                        ) {
                            stack.push(intArrayOf(nr, nc))
                            seen[nr][nc] = true
                        }
                    }
                }
                ans = Math.max(ans, shape)
            }
        }
    }
    return ans
}