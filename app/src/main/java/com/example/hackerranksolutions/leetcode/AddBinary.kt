package com.example.hackerranksolutions.leetcode

fun main() {
    println(addBinary("11", "1"))
    println(addBinary("1010", "1011"))
    println(addBinary("1111", "1111"))
}

fun addBinary(a: String, b: String): String {

    if (a.isEmpty()) return b
    if (b.isEmpty()) return a

    var carry = 0
    val totalBinary = StringBuilder()

    var aLength = a.length - 1
    var bLength = b.length - 1
    while (aLength >= 0 || bLength >= 0) {
        var total = carry
        if (aLength >= 0) {
            total += a[aLength].toString().toInt()
        }
        if (bLength >= 0) {
            total += b[bLength].toString().toInt()
        }
        totalBinary.insert(0, total % 2)
        carry = if (total >= 2) 1 else 0
        aLength--
        bLength--
    }
    if (carry > 0) {
        totalBinary.insert(0, carry)
    }
    return totalBinary.toString()
}