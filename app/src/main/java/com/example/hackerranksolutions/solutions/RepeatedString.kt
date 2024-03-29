package com.example.hackerranksolutions.solutions

fun main() {
    println(repeatedString("ab", 10))
}

fun repeatedString(s: String, n: Long): Long {

    val remainingValue = n % s.length
    val aCount = s.count { it == 'a' }

    val lengthOfLetter: Long = if (remainingValue == 0L) {
        aCount * (n / s.length)
    } else {
        val myString = s.subSequence(0, remainingValue.toInt())

        myString.count { it == 'a' }.toLong() + aCount * (n / s.length)
    }

    return lengthOfLetter

}