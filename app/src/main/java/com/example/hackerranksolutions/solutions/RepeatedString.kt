package com.example.hackerranksolutions.solutions

fun main() {
    println(repeatedString("aba", 10))
}

fun repeatedString(s: String, n: Long): Long {

    val lengthOfLetter: Long
    val remainingValue = n % s.length
    val aCount = s.count { it == 'a' }


    if (remainingValue == 0L) {
        lengthOfLetter = aCount * (n / s.length)
    } else {
        val myString = s.subSequence(0, remainingValue.toInt())

        lengthOfLetter = myString.count { it == 'a' }.toLong() + aCount * (n / s.length)
    }

    return lengthOfLetter

}