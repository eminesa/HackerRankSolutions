package com.example.hackerranksolutions.solutions

fun main() {
    //println(gridChallenge(arrayOf("cba","ade","dfg")))
    println(gridChallenge(arrayOf("eabcd", "fghij", "olkmn", "trpqs", "xywuv")))
}

fun gridChallenge1(grid: Array<String>): String { // row control
    var sortGrid = "NO"
    var index = 0

    while (index < grid.size){

        if (grid[index].zip(grid[index].drop(1)).all { (a, b) -> a <= b }){
            sortGrid = "YES"
            index++
        } else{
            sortGrid = "NO"
            index = grid.size
        }
    }

    return sortGrid
}

fun gridChallenge(grid: Array<String>): String { // colon control

    var ok = true
    var sizeGrid = grid.size

    while (sizeGrid -- > 0) {

        for (i in 0 until sizeGrid) {
            for (j in 1 until sizeGrid) {
                if (grid[j][i] < grid[j - 1][i]) {
                    ok = false
                    break
                }
            }
        }
    }

    return  if (ok) "YES" else "NO"
}


