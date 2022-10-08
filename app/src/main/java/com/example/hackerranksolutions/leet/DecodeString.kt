package com.example.hackerranksolutions.leet

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    println(decodeString("3[a]2[bc]")) // the same time
}

fun decodeStringMySolution(s: String): String {
    // firstly create a StringBuilder for keep my adding string
    // create a StringBuilder for result string
    // check if it is digit
    // check if it is [ start add keep string.
    // start while when get ] char
    // if s is end return the string
    val keepingString = StringBuilder()
    val resultString = StringBuilder()
    var returnTime = 0
    for (element in s) {
        when {
            element.isDigit() -> {
                returnTime = element.toString().toInt()
            }
            element == '[' -> {
                keepingString.clear()
            }
            element == ']' -> {
                for (time in 1..returnTime) {
                    resultString.append(keepingString)
                }
            }
            else -> {
                keepingString.append(element)
            }
        }

    }
    return resultString.toString()
}

fun decodeString(s: String): String {
    val stack: Stack<Char> = Stack()

    for (i in s.indices) {
        if (s[i] == ']') {
            val decodedString: MutableList<Char> = ArrayList()
            // get the encoded string
            while (stack.peek() != '[') {
                decodedString.add(stack.pop())
            }
            // pop [ from the stack
            stack.pop()
            var base = 1
            var k = 0
            // get the number k
            while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                k += (stack.pop() - '0') * base
                base *= 10
            }
            // decode k[decodedString], by pushing decodedString k times into stack
            while (k != 0) {
                for (j in decodedString.indices.reversed()) {
                    stack.push(decodedString[j])
                }
                k--
            }
        } else {
            stack.push(s[i])
        }
    }
    // get the result from stack
    val result = CharArray(stack.size)
    for (i in result.indices.reversed()) {
        result[i] = stack.pop()
    }
    return String(result)
}