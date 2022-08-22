package com.example.hackerranksolutions.solutions

fun main() {
     //println(superDigit("9875987598759875", 4))
    // println(superDigit("148", 3))
  //  println(superDigit("9875", 4))
    println(superDigit("9875", 4))
}

fun superDigit(n: String, k: Int): Int {
    var superSum = 0
    var superSumList = n.toCharArray()
    var lengthString = n.length

    while (lengthString > 1) {

        superSum = 0
        superSumList.map { value ->
            superSum += value.toString().toInt()
        }

        superSumList = superSum.toString().toCharArray()
        lengthString = superSum.toString().length
    }

    return superSum
}

