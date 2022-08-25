package com.example.hackerranksolutions.leet

import java.lang.StringBuilder

fun main() {
// start = "RXXLRXRXL", end = "XRLXXRRLX"
    println(canTransform1("RXXLRXRXL", "XRLXXRRLX"))
}

fun canTransform1(start: String, end: String): Boolean {

    if (start.length <= 1) return false
    var i = 0
    val updateStart = StringBuilder()
    var newStart = start

    while (i < start.length) {

        when (newStart[i].toString().plus(if (i + 1 < start.length) newStart[i + 1] else "")) {
            "XL" -> {
                updateStart.append("LX")
                i = checkIndex(i, start.length)
            }
            "RX" -> {
                updateStart.append("XR")
                i = checkIndex(i, start.length)
            }
            else -> {
                updateStart.append(newStart[i])
                i = checkIndex(i, start.length)
            }
        }

        println(updateStart)

    }
    return updateStart.toString() == end
}

fun checkIndex(index: Int, size: Int): Int {

    return if (index + 2 < size)
        index + 2
    else index + 1

}
