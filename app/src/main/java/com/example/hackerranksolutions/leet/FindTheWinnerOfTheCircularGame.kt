package com.example.hackerranksolutions.leet

fun main() {
    println(findTheWinner(6, 5))
    println(findTheWinner(5, 2))
}

fun findTheWinner(n: Int, k: Int): Int {
    //n = gamer
    //k = in one time return on gamer
    val gamerList: MutableList<Int> = ArrayList()
    for (index in 0 until n) {
        gamerList.add(index + 1)
    }
    // I have a gamer list
    // I have to check my all list a
    var currentIndex = 0
    while (gamerList.size > 1) {
        currentIndex = currentIndex + k - 1

        while (currentIndex > gamerList.size - 1) {
            currentIndex -= gamerList.size
        }

        gamerList.removeAt(currentIndex)
    }

    return gamerList.first()
}