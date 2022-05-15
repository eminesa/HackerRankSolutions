package com.example.hackerranksolutions.solutions

fun main() {
    println(compareTriplets(arrayOf(1, 2, 3), arrayOf(2, 1, 4)))
    println(compareTriplets1(arrayOf(1, 2, 3), arrayOf(2, 1, 4)))
    println(compareTriplets2(arrayOf(1, 2, 3), arrayOf(2, 1, 4)))
}


fun compareTriplets(a: Array<Int>, b: Array<Int>): Array<Int> {

    var scoreOfAlice = 0
    var scoreOfBob = 0

    for (index in a.indices) {
        if (a[index] > b[index]) {
            scoreOfAlice += 1
        } else if (b[index] > a[index]) {
            scoreOfBob += 1
        }
    }

    return arrayOf(scoreOfAlice, scoreOfBob)
}

fun compareTriplets1(a: Array<Int>, b: Array<Int>): Array<Int> {

    var scoreOfAlice = 0
    var scoreOfBob = 0

    for (index in a.indices) {
        when {
            a[index] > b[index] -> {
                scoreOfAlice ++
            }
            b[index] > a[index] -> {
                scoreOfBob ++
            }
        }
    }

    return arrayOf(scoreOfAlice, scoreOfBob)
}

fun compareTriplets2(a: Array<Int>, b: Array<Int>): Array<Int> {

    val scoreOfAlice = a.zip(b).count { it.first > it.second }
    val scoreOfBob = a.zip(b).count { it.second > it.first }

    return arrayOf(scoreOfAlice, scoreOfBob)
}


