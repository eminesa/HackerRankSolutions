package com.example.hackerranksolutions.solutions

import kotlin.math.pow

fun main() {
    // println(counterGame(132))
    //  println(counterGame(1560834904))
    // println(counterGame(1768820483))
    println(counterGame(1533726144))
    // println(counterGame(1620434450))
    // println(counterGame(1463674015))
}

fun counterGame(n: Long): String {

    var countDown = 0L
    var powValue = 1

    while (countDown <= n) {
        countDown = 2.toDouble().pow(powValue).toLong()

        if (countDown <= n) {
            powValue++
            if (2.toDouble().pow(powValue).toLong() > n) {
                powValue--
                countDown += countDown
            }
        } else {
            countDown += countDown
        }
    }

    return if (powValue % 2 == 0) "Louise" else "Richard"
}

