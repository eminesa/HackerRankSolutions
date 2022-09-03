package com.example.hackerranksolutions.leet

import java.util.*
import kotlin.collections.HashMap


fun main() {
    //println(isValid("()[]{}"))
    println(isValid("()[{}]("))
   // println(isValid("()[{}]"))
}

fun isValidMine(s: String): Boolean {
    // about zero
    var currentString = s

    if (s.length < 2 || s.length % 2 == 1) {
        return false
    } else {
        while (currentString.length > 1) {

            val stringLength = currentString.length - 1
            when (currentString[0]) {
                '(' -> {
                    if (currentString[1] != ')' && currentString[stringLength] != ')') {
                        return false
                    } else if (currentString[1] == ')') {
                        currentString = currentString.removeRange(0, 2)

                    } else if (currentString[stringLength] != ')') {
                        currentString = currentString.removeRange(stringLength, stringLength)
                        currentString = currentString.removeRange(0, 1)
                    }

                }
                '[' -> {
                    if (currentString[1] != ']' && currentString[stringLength] != ']') {
                        return false
                    } else if (currentString[1] == ']') {
                        currentString = currentString.removeRange(0, 2)

                    } else if (currentString[stringLength] == ']') {
                        currentString = currentString.removeRange(stringLength, stringLength)
                        currentString = currentString.removeRange(0, 1)
                    }
                }

                '{' -> {
                    if (currentString[1] != '}' && currentString[stringLength] != '}') {
                        return false
                    } else if (currentString[1] == '}') {
                        currentString = currentString.removeRange(0, 2)

                    } else if (currentString[stringLength] == '}') {
                        currentString = currentString.removeRange(stringLength, stringLength)
                        currentString = currentString.removeRange(0, 1)
                    }

                }
            }

        }
    }

    return true
}

fun isValid(s: String): Boolean {

    if (s.length % 2 == 1) return false

    val mappings: HashMap<Char, Char> = HashMap()
    mappings[')'] = '('
    mappings['}'] = '{'
    mappings[']'] = '['

    // Initialize a stack to be used in the algorithm.
    val stack: Stack<Char> = Stack<Char>()

    for (element in s) {

        // If the current character is a closing bracket.
        if (mappings.containsKey(element)) {

            // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
            val topElement = if (stack.empty()) '#' else stack.pop()

            // If the mapping for this bracket doesn't match the stack's top element, return false.
            if (topElement != mappings[element]) {
                return false
            }
        } else {
            // If it was an opening bracket, push to the stack.
            stack.push(element)
        }
    }

    // If the stack still contains elements, then it is an invalid expression.
    return stack.isEmpty()
}