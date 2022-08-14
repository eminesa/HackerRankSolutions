package com.example.hackerranksolutions.solutions

import java.util.*

fun main() {

    val result =   bigSorting(arrayOf("1", "45", "7", "6", "78"))

    println(result.joinToString(" "))

    val result1 =   bigSorting1(arrayOf("1", "45", "7", "6", "78"))

    println(result1.joinToString(" "))
}

fun bigSorting(unsorted: Array<String>): Array<String> {

    Arrays.sort(unsorted) { x, y ->
        if (x.length == y.length) x.compareTo(y) else x.length.compareTo(y.length)
    }
    return unsorted

}

fun bigSorting1(unsorted: Array<String>): Array<Int> {

    val listOfMine = mutableListOf<Int>()
    unsorted.map {
        listOfMine.add(it.toInt())
    }
    return  listOfMine.sorted().toTypedArray()
}

fun bigSorting2(unsorted: Array<String>): Array<String> {
   // bunu kabul etmedi sebebini de bilmiyorum 9/5 yapti bu
    return unsorted.map { it.toBigInteger()}.sorted().map { it.toString() }.toTypedArray()
}


