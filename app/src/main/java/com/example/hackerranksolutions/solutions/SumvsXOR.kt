package com.example.hackerranksolutions.solutions

import kotlin.math.pow

fun main() {

   print(sumXor(5))
}

fun sumXor(n: Long): Long {

    if (n.toInt() == 0) return 1

    val binary = java.lang.Long.toBinaryString(n)
    val zeros = binary.toCharArray().filter { ch -> ch == '0' }.count()
    return 2.0.pow(zeros.toDouble()).toLong()

}