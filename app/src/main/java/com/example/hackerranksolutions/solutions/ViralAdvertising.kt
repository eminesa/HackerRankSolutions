package com.example.hackerranksolutions.solutions

fun main() {
    println(viralAdvertising(3))
}

fun viralAdvertising(n: Int): Int {

    var cumulative = 0
    var liked: Int
    var shared = 5

    for (day in 1..n) {
        liked = shared / 2
        cumulative += liked
        shared = liked * 3

    }

    return cumulative
}
