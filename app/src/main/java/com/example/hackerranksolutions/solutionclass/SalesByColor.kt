package com.example.hackerranksolutions.solutionclass


fun main() {
    println(sockMerchant(arrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20)))
    println(sockMerchant1(arrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20)))
}

fun sockMerchant(ar: Array<Int>): Int {

    val hashMap = HashMap<Int, Int>()
    var pairSock = 0

    for (element in ar) {

        if (hashMap.keys.contains(element)) {
            hashMap.put(element, hashMap.getValue(element) + 1)
        } else {
            hashMap.put(element, 1)
        }
    }

    val elementList = ar.distinct().toList()

    for (index in elementList) {
        pairSock += hashMap.getValue(index) / 2
    }

    return pairSock
}

fun sockMerchant1(ar: Array<Int>): Int {

    val hashMap = HashMap<Int, Int>()
    var pairSock = 0

    ar.map { element ->
        if (hashMap.keys.contains(element)) {
            hashMap.put(element, hashMap.getValue(element) + 1)
        } else {
            hashMap.put(element, 1)
        }
    }

    val elementList = ar.distinct().toList()

    elementList.mapIndexed { index, i ->   pairSock += hashMap.getValue(i) / 2}

    return pairSock
}
