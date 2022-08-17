package com.example.hackerranksolutions.sorted

// time complexity = n^2 (n kare- n square)
fun main() {
    println(insertionSort(arrayOf(4, 5, 8, 1, 9, 2, 15)).contentToString())
    println(insertionSort(arrayOf(5, 7, -2, 9, 6, 1, 3, 7)).contentToString())
    println(insertionSort(arrayOf(1, 2, 3, 5, 6, 7, 7, 9)).contentToString())
}

fun insertionSort(array:Array<Long>):Array<Long>{

    for(index in 1 until array.size) {
        var whileIndex = index - 1
        val key = array[index]

        while (whileIndex >= 0 && key < array[whileIndex]) {
            array[whileIndex + 1] = array[whileIndex]
            whileIndex--
        }

        array[whileIndex + 1] = key
    }

    return array
}