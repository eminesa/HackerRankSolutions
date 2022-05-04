package com.example.hackerranksolutions.solutionclass

fun main() {
    println(birthday(arrayOf(2,2,1,3,2),4,2))
}

fun birthday(s: Array<Int>, d: Int, m: Int): Int {

    var count = 0
    for (i in 0..s.size - m) {
        var sum = 0

        for (j in i until i + m) {
            sum += s[j]
        }

        if (sum == d) {
            count++
        }
    }
    return count
}