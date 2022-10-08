package com.example.hackerranksolutions.solutions

fun main() {
    //val result = countingSort(arrayOf(19, 10, 12, 10, 24, 25, 22))
    val result = countingSort(arrayOf(1, 1, 3, 2, 1))
    println(result.joinToString(", "))
}

fun countingSort(arr: Array<Int>): Array<Int> {
    val freqArray: MutableList<Int> = ArrayList()

    for (i in 0..99) {
        freqArray.add(0)
    }

    for (element in arr) {
        val freq = freqArray[element]
        freqArray[element] = freq + 1
    }

    return freqArray.toTypedArray()
}