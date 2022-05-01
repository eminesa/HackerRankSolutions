package com.example.hackerranksolutions.solutionclass

fun main() {

    println(migratoryBirds(arrayOf(1, 4, 4, 4, 5, 3)))

}

fun migratoryBirds(ar: Array<Int>): Int {

    val birdArray = IntArray(ar.size){0}

    for (element in ar) {
        birdArray[element]++
    }

    var max = 0
    var maxpos = 0

    for (i in ar.indices) {
        if (birdArray[i] > max) {
            max = birdArray[i]
            maxpos = i
        }
    }
    return maxpos

}
fun migratoryBirds1(ar: Array<Int>): Int {

    val birdArray = IntArray(ar.size){0}

    ar.mapIndexed { index, i ->  birdArray[index]++  }

    var max = 0
    var maxpos = 0

    ar.mapIndexed { index, i ->

    }
    for (i in ar.indices) {
        if (birdArray[i] > max) {
            max = birdArray[i]
            maxpos = i
        }
    }
    return maxpos

}