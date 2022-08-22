package com.example.hackerranksolutions.solutions

fun main() {

    println(lonelyinteger(arrayOf(1,2,3,4,3,2,1)))
}

fun lonelyinteger(a: Array<Int>): Int {
    var uniuqe = 0

    a.distinct().map { element ->
       val sizeOfElement = a.count { element == it }
        if (sizeOfElement<2){
            uniuqe = element
        }
    }

    return uniuqe
}