package com.example.hackerranksolutions.leetcode

import androidx.core.text.isDigitsOnly

fun main() {
    val array = arrayOf("5", "*", "4", "+", "9", "-", "2", "/", "3", "+", "1")
    println(evalRPN(array))
}

fun evalRPN(tokens: Array<String>): Int {

    val count = 0

    if (tokens.size % 2 == 1) {
        val currentPosition = (tokens.size - 1).div(2)
        if (tokens[currentPosition].isDigitsOnly()) {

        }
    }

    return count
}

fun calculate(type: String, firstElement: Int, secondElement: Int): Int {

     when (type) {
        "-" -> {
            return firstElement.minus(secondElement)
        }
        "+" -> {
            return firstElement.plus(secondElement)
        }
        "*" -> {
            return firstElement.times(secondElement)
        }
        "/" -> {
            return firstElement.div(secondElement)
        }
        else -> {
            return 0
        }
    }
}

