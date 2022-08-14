package com.example.hackerranksolutions.solutions


fun main() {

    println(utopianTree(3))
}


fun utopianTree1(n: Int): Int {

    val MONSOON = 100 //
    val SUMMER = 200

    var treeHeight = 1
    var cycleType = SUMMER
    for (season in 1..n) {

        when (cycleType) {
            MONSOON -> {
                treeHeight *= 2
                cycleType = SUMMER
            }
            SUMMER -> {
                treeHeight += 1
                cycleType = MONSOON
            }
        }

    }
    return treeHeight
}


fun utopianTree(n: Int): Int {

    val MONSOON = 100
    val SUMMER = 200
    var treeHeight = 0
    for (i in 0 until n) {
        treeHeight = 1
        var cycleType = MONSOON
        for (j in 0 until n) {
            when (cycleType) {
                MONSOON -> {
                    treeHeight *= 2
                    cycleType = SUMMER
                }
                SUMMER -> {
                    treeHeight += 1
                    cycleType = MONSOON
                }
            }
        }

     }

    return treeHeight
}

