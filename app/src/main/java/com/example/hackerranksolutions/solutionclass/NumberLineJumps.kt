package com.example.hackerranksolutions.solutionclass


fun main() {
    println(kangaroo(0, 3, 4, 2))
    println(kangaroo1(0, 3, 4, 2))

}

fun kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String {

    return if (v1 > v2) {
        if ((x2 - x1) % (v1 - v2) == 0) {
            "YES"
        } else {
            "NO"
        }
    } else {
        "NO"
    }

}

fun kangaroo1(x1: Int, v1: Int, x2: Int, v2: Int): String = if (v1 > v2) {

    if ((x2 - x1) % (v1 - v2) == 0) {
        "YES"
    } else {
        "NO"
    }
} else {
    "NO"
}
