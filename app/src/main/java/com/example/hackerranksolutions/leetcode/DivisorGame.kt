package com.example.hackerranksolutions.leetcode

fun main() {
    println(divisorGame(2))
    println(divisorGame(3))
    println(divisorGame(5))
}

fun divisorGame(n: Int): Boolean {
    return n % 2 == 0
}