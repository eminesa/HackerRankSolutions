package com.example.hackerranksolutions.leet

fun main() {
    println(isHappy(92))
    println(isHappy(19))
    println(isHappy(7))
    println(isHappy(1111111))
}

fun isHappy1(n: Int): Boolean { // MY WAY
    if (n == 1) return true

    var currentStringList = n.toString().toList() // O(n)
    val currentIntList: MutableList<Int> = ArrayList()  // O(n)
    currentIntList.add(n)
    var calculater: Int
    var currentSize = currentStringList.size

    while (currentSize > 0) { // O(n*currentSize)

        calculater = 0
        for (index in 0 until currentSize) {
            calculater += currentStringList[index].toString()
                .toInt() * currentStringList[index].toString()
                .toInt()
        }
        currentStringList = calculater.toString().toList()
        currentSize = currentStringList.size

        if (calculater == 1) {
            return true
        } else if (currentIntList.contains(calculater)) {
            return false
        } else {
            currentIntList.add(calculater)
        }
    }

    return currentStringList.first() == '1'
}

fun getNext(n: Int): Int {
    var totalInt = n
    var totalSum = 0
    while (totalInt > 0) {
        val d = totalInt % 10
        totalInt /= 10
        totalSum += d * d
    }
    return totalSum
}

fun isHappy(n: Int): Boolean {
    var totalInt = n
    while (totalInt != 1 && totalInt != 4) {
        totalInt = getNext(totalInt)
    }
    return totalInt == 1
}