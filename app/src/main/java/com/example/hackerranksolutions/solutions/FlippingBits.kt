package com.example.hackerranksolutions.solutions

import kotlin.math.pow

fun main() {
   println( flippingBits(2147483647))
}

fun flippingBits(n: Long): Long {

    return (2.0.pow(32.0) - n - 1).toLong()
}
