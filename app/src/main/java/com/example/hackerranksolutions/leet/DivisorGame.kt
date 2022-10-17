package com.example.hackerranksolutions.leet

fun main() {
    println(divisorGame(2))
    println(divisorGame(3))
    println(divisorGame(5))
}

fun divisorGame(n: Int): Boolean {
    return n % 2 == 0
}