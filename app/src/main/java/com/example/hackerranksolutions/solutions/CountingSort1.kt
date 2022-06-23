package com.example.hackerranksolutions.solutions

fun main() {

    val result= countingSort(arrayOf(19, 10, 12, 10, 24, 25, 22))
    println(result.joinToString(" "))

}

fun countingSort(arr: Array<Int>): Array<Int> {
    val freqArray: MutableList<Int> = ArrayList()
    var value: Int
    var freq: Int

    for (i in 0..99) {
        freqArray.add(0)
    }

    for (element in arr) {
        value = element
        freq = freqArray[value]
        freqArray[value] = freq + 1
    }

    return freqArray.toTypedArray()
}