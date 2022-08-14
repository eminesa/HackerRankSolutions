package com.example.hackerranksolutions.solutions

fun main() {
   // val result = icecreamParlor(4, arrayOf(1, 4, 5, 3, 2))
    val result = icecreamParlor(4, arrayOf(2, 2,4, 3))
    println(result.joinToString(" "))
}


fun icecreamParlor(m: Int, arr: Array<Int>): Array<Int> {

    val list = mutableListOf<Int>()

    for (firstPrice in arr.indices) {

        for (secondPrice in firstPrice + 1 until arr.size) {
            if (arr[firstPrice] + arr[secondPrice] == m) {
                list.clear()
                list.add(firstPrice+1)
                list.add(secondPrice+1)
            }
        }
    }

    return list.toTypedArray()
}