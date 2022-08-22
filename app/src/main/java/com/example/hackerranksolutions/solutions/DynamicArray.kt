package com.example.hackerranksolutions.solutions

fun main() {
    dynamicArray(
        2,
        arrayOf(
            arrayOf(1, 0, 5),
            arrayOf(1, 1, 7),
            arrayOf(1, 0, 3),
            arrayOf(2, 1, 0),
            arrayOf(2, 1, 1))
    )
}

fun dynamicArray(n: Int, queries: Array<Array<Int>>): Array<Int> {
    val listOfLast = mutableListOf<Int>()

    queries.map {
     println(it.joinToString(" "))
    }

    return listOfLast.toTypedArray()
}