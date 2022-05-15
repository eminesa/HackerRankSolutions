package com.example.hackerranksolutions.solutions

fun main() {
    bonAppetit(arrayOf(3, 10, 2, 9), 1, 12)
    bonAppetit1(arrayOf(3, 10, 2, 9), 1, 12)
}

fun bonAppetit(bill: Array<Int>, k: Int, b: Int): Unit {

    var totalPrice = 0

    for (i in bill.indices) {
        if (i != k) {
            totalPrice += bill[i]
        }
    }

    val halfPrice = totalPrice / 2

    println(
        if (halfPrice == b) "Bon Appetit"
        else b - halfPrice
    )
}

fun bonAppetit1(bill: Array<Int>, k: Int, b: Int): Unit {

    var totalPrice = 0

    bill.mapIndexed { index, i ->
        if (index != k) {
            totalPrice += i
        }
    }

    val halfPrice = totalPrice / 2

    println(
        when (halfPrice) {
            b -> "Bon Appetit"
            else -> b - halfPrice
        }
    )
}