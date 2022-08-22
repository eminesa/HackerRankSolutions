package com.example.hackerranksolutions.solutions

fun main() {
    println(jumpingOnClouds(arrayOf(0, 0, 1, 0, 0, 1, 1, 0), 2))
    println(jumpingOnClouds(arrayOf(1, 1, 1, 0, 1, 1, 0, 0, 0, 0), 3))
}

fun jumpingOnClouds(c: Array<Int>, k: Int): Int {

    var energy = 100

    var index = 0

    while (index <= c.size - 1) {
        energy -= 1

        if (c[index] == 1) energy -= 2
        index += k
    }

    return energy
}