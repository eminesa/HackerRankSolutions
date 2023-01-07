package com.example.hackerranksolutions.leetcode

fun main() {
    val result = relativeSortArray(
        intArrayOf(2, 3, 1, 3, 2, 4, 6, 19, 9, 2, 7),
        intArrayOf(2, 1, 4, 3, 9, 6)
    )

    println(result.joinToString(", "))
}

fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {

    var currentList = arr1.toMutableList()

    var indexArr2 = 0
    var indexOfArr1 = 0
    while (indexArr2 < arr2.size) {
        val value = arr2[indexArr2]
        while (currentList.contains(value)) {
            currentList.remove(value)
            arr1[indexOfArr1] = value
            indexOfArr1++
        }
        indexArr2++
    }

   val newList =  currentList.sorted()
    currentList.clear()
    currentList = newList.toMutableList()
    while (currentList.isNotEmpty()) {

        arr1[indexOfArr1] = currentList.first()
        currentList.remove(currentList.first())

        indexOfArr1++
    }

    return arr1
}


