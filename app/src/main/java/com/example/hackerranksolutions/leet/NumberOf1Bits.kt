package com.example.hackerranksolutions.leet

fun main() {
    println(hammingWeight(521))
}
fun hammingWeight(n: Int): Int {

    var temporaryNumber = n
    var sum = 0
    while (temporaryNumber != 0) {
        sum++
        temporaryNumber = temporaryNumber and temporaryNumber - 1
    }

    return sum
}

