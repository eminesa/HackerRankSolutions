package com.example.hackerranksolutions.solutionclass

fun main() {

    countApplesAndOranges(7, 11, 5, 15, arrayOf(-2, 2, 1), arrayOf(5, -6))
}

fun countApplesAndOranges(
    startPointHome: Int,
    endPointHome: Int,
    appleLoc: Int,
    orangeLoc: Int,
    apples: Array<Int>,
    oranges: Array<Int>
): Unit {
    var orangeOnHouse = 0
    var applesOnHouse = 0

// Calculate of apples that fall on house
    for (apple in apples) {
        val applePosition = appleLoc + apple
        if (applePosition in startPointHome..endPointHome) {
            applesOnHouse++
        }
    }
// Calculate of orange that fall on house
    for (orange in oranges) {
        val orangePosition = orangeLoc + orange
        if (orangePosition in startPointHome..endPointHome) {
            orangeOnHouse++
        }
    }
    println(applesOnHouse)
    println(orangeOnHouse)
}
