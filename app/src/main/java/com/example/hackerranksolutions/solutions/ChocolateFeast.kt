package com.example.hackerranksolutions.solutions

fun main() {

    println(chocolateFeast(n = 6, c = 2, m = 2))

}

fun chocolateFeast(n: Int, c: Int, m: Int): Int {

    val chocs = n / c
    var wrapper = chocs
    var exChocs = wrapper / m

    while (wrapper >= m) {
        exChocs += (wrapper / m + wrapper % m) / m
        wrapper /= m
    }

    return exChocs + chocs

}