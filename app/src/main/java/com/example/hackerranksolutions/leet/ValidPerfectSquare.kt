package com.example.hackerranksolutions.leet

fun main() {
    println(isPerfectSquare(16))
    println(isPerfectSquare(4))
    println(isPerfectSquare(3))
    println(isPerfectSquare(14))
}

fun isPerfectSquare(num: Int): Boolean {

    if (num == 0 || num == 1) return true

    for (index in 0..num / 2) {
        if (index * index == num) {
            return true
        }
    }

    return false
}
