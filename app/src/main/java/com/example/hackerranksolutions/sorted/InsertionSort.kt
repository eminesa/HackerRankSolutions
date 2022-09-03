package com.example.hackerranksolutions.sorted


fun main() {
    println(sort(intArrayOf(4, 5, 8, 1, 9, 2, 15)).contentToString())
    println(insertionSort(arrayOf(5, 7, -2, 9, 6, 1, 3, 7)).contentToString())
    println(insertionSort(arrayOf(1, 2, 3, 5, 6, 7, 7, 9)).contentToString())
    //println(insertionSort(arrayOf(4, 5, 8, 1, 9, 2, 15)).contentToString())
    //println(insertionSort(arrayOf(5, 7, -2, 9, 6, 1, 3, 7)).contentToString())
    //println(insertionSort(arrayOf(1, 2, 3, 5, 6, 7, 7, 9)).contentToString())
}

// time complexity = n^2 (n kare- n square)
// space complexity  = O(1)
fun insertionSort(array: Array<Long>): Array<Long> {
    val size = array.size
    for (index in 1 until size) {
        var whileIndex = index - 1
        val key = array[index]

        while (whileIndex >= 0 && key < array[whileIndex]) {
            array[whileIndex + 1] = array[whileIndex]
            whileIndex -= 1
        }

        array[whileIndex + 1] = key
    }

    return array
}

fun sort(arr: IntArray): IntArray {
    val n = arr.size

    // One by one move boundary of unsorted subarray
    for (i in 0 until n) {
        // Find the minimum element in unsorted array
        var minIdx = i
        for (j in i + 1 until n) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j
                break
            }
        }

        // Swap the found minimum element with the first
        // element
        val temp = arr[minIdx]
        arr[minIdx] = arr[i]
        arr[i] = temp
    }
    return arr
}