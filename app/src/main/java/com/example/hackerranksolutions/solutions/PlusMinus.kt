package com.example.hackerranksolutions.solutions

fun main() {

    plusMinus(arrayOf(1,2,3,45,-1,0,0,0,-30))
    plusMinus1(arrayOf(1,2,3,45,-1,0,0,0,-30))
}

fun plusMinus(arr: Array<Int>): Unit {
    var plusElement = 0f
    var minusElement = 0f
    var zeroElement = 0f

    for (index in arr) {
        if (index > 0) plusElement += 1
        else if (index < 0) minusElement += 1
        else if (index == 0) zeroElement += 1
    }

    plusElement = (plusElement / arr.size)
    minusElement = (minusElement / arr.size)
    zeroElement = (zeroElement / arr.size)

    println(plusElement)
    println(minusElement)
    println(zeroElement)
}

fun plusMinus1(arr: Array<Int>): Unit {
    var plusElement = 0f
    var minusElement = 0f
    var zeroElement = 0f

    for (index in arr) {
        when {
            index > 0 -> plusElement += 1
            index < 0 -> minusElement += 1
            index == 0 -> zeroElement += 1
        }
    }

    plusElement = (plusElement / arr.size)
    minusElement = (minusElement / arr.size)
    zeroElement = (zeroElement / arr.size)

    println(plusElement)
    println(minusElement)
    println(zeroElement)
}
