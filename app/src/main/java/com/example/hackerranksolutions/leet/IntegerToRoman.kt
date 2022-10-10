package com.example.hackerranksolutions.leet

fun main() {
    println(intToRoman(100))
}

fun intToRoman12(num: Int): String {

    val romanString = StringBuilder()
    var currentNum = num
    var numberLength = currentNum.toString().length

    while (currentNum > 0) {
        val temporaryNumber = currentNum % numberLength
        currentNum -= temporaryNumber
        numberLength = currentNum.toString().length
        when (temporaryNumber) {
            1 -> {
                romanString.append("I")
            }
            4 -> {
                romanString.append("IV")
            }
            5 -> {
                romanString.append("V")
            }
            9 -> {
                romanString.append("IX")
            }
            10 -> {
                romanString.append("X")
            }
            40 -> {
                romanString.append("XL")
            }
            50 -> {
                romanString.append("L")
            }
            90 -> {
                romanString.append("CX")
            }
            100 -> {
                romanString.append("C")
            }
            400 -> {
                romanString.append("CD")
            }
            500 -> {
                romanString.append("D")
            }
            900 -> {
                romanString.append("CM")
            }
            1000 -> {
                romanString.append("M")
            }
        }
    }



    return romanString.toString()
}

fun intToRoman(num: Int): String {

    val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    val symbols =
        arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    var currentNum = num
    val sb = StringBuilder()
    // Loop through each symbol, stopping if num becomes 0.
    var i = 0
    while (i < values.size && currentNum > 0) {

        // Repeat while the current symbol still fits into num.
        while (values[i] <= currentNum) {
            currentNum -= values[i]
            sb.append(symbols[i])
        }
        i++
    }
    return sb.toString()
}
