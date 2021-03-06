package com.example.hackerranksolutions.solutions

fun main() {
    println(divisibleSumPairs(3, arrayOf(1, 3, 2, 6, 1, 2)))
}

fun divisibleSumPairs(k: Int, ar: Array<Int>): Int {

    var sum = 0

    for (arrIndex in ar.indices) {

        for (index in ar.indices) {

            if (arrIndex != index && arrIndex < index) {

                val isDivided = ((ar[arrIndex] + ar[index]) % k) == 0

                if (isDivided) {
                    sum += 1
                }

            }

        }
    }

    return sum
}

