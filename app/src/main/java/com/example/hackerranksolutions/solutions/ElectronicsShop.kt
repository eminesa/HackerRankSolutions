package com.example.hackerranksolutions.solutions

fun main() {

    println(getMoneySpent(arrayOf(40, 50, 60), arrayOf(5, 8, 12), 60))

}

fun getMoneySpent(keyboards: Array<Int>, drives: Array<Int>, b: Int): Int {

    var result: Int = -1
    keyboards.map { keyboardPrice ->
        drives.map { drivePrice ->

            val total = keyboardPrice + drivePrice

            result = if (total in (result + 1)..b) {
                total
            } else {
                result
            }
        }
    }

    return result

}