package com.example.hackerranksolutions.solutions

fun main() {
    val result = reverseArray(arrayOf(1, 2, 3))

    println(result.joinToString(" "))
}

fun reverseArray(a: Array<Int>): Array<Int> {

    val startFormLast = mutableListOf<Int>()

    for (index in a.size - 1 downTo 0) {
        startFormLast.add(a[index])
    }

    return startFormLast.toTypedArray()

}
