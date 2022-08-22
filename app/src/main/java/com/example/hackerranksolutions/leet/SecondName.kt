package com.example.hackerranksolutions.leet

import java.util.*

fun main() {
    println(evalRPN(arrayOf("2","1","+","3","*")))
}

fun evalRPN(tokens: Array<String?>): Int {

    val stack: Stack<Int> = Stack()

    for (token in tokens) {
        if ((token?.let { "+-*/".contains(it) } == false)) {
            stack.push(Integer.valueOf(token))
            continue
        }
        val number2: Int = stack.pop()
        val number1: Int = stack.pop()

        var result = 0
        when (token) {
            "+" -> result = number1 + number2
            "-" -> result = number1 - number2
            "*" -> result = number1 * number2
            "/" -> result = number1 / number2
        }
        stack.push(result)
    }
    return stack.pop()
}
