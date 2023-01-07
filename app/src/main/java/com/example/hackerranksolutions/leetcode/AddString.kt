package com.example.hackerranksolutions.leetcode

import java.lang.StringBuilder

fun main() {
    println(addStrings("1", "9"))
}

fun addStrings(num1: String, num2: String): String {

    if (num1.isEmpty() && num2.isEmpty()) return "0"
    if (num1.isEmpty()) return num2
    if (num2.isEmpty()) return num1

    // val minString
    val maxList = if (num1.length >= num2.length) num1 else num2
    val minList = if (num1.length < num2.length) num1 else num2
    var carry = 0
    var minIndex = minList.length - 1
    var maxIndex = maxList.length - 1
    val addString = StringBuilder()

    while (maxIndex >= 0) {
        var value = carry
        value += if (minIndex >= 0) {
            minList[minIndex].toString().toInt() + maxList[maxIndex].toString().toInt()
        } else {
            maxList[maxIndex].toString().toInt()
        }
        carry = value / 10
        value %= 10
        addString.append(value)
        maxIndex--
        minIndex--
    }

    if (carry>0) addString.append(carry)

    return addString.reverse().toString()
}
