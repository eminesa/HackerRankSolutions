package com.example.hackerranksolutions.leetcode

fun main() {
    println(myAtoi("   -42 4193 with words"))
    println(myAtoi("42"))
    println(myAtoi("4193 with words"))
    println(myAtoi("with words 4235"))
    println(myAtoi("+1"))
    println(myAtoi("+-12"))
    println(myAtoi("21474836460"))
    println(myAtoi("-91283472332"))
}

fun myAtoi1(s: String): Int { // passed 45 / 1082 test case :(

    if (s.isEmpty()) return 0
    val atoiInt = StringBuilder()
    var currentString = s
    var prefix = "+"
    while (currentString.startsWith(" ") || currentString.startsWith("0") ||
        currentString.startsWith("-") || currentString.startsWith("+")
    ) { // remove 0 and -
        if (currentString.startsWith(" ")) {
            currentString = currentString.removePrefix(" ")
        } else if (currentString.startsWith("0")) {
            currentString = currentString.removePrefix("0")
        } else if (currentString.startsWith("-")) {
            prefix = "-"
            currentString = currentString.removePrefix("-")
        } else if (currentString.startsWith("+")) {
            prefix = "+"
            currentString = currentString.removePrefix("+")
        }
    }

    for (index in currentString.indices) {
        if (currentString[index].isDigit()) {
            atoiInt.append(currentString[index])
        } else if (currentString[index] == ' ') {
            continue
        } else {
            return if (atoiInt.toString().isEmpty()) 0
            else {
                prefix.plus(atoiInt.toString()).toInt()
            }
        }
    }

    val control = prefix.plus(atoiInt.toString())

    if (atoiInt.toString().isEmpty()) {
        return 0
    } else if (control.toLong() < Int.MIN_VALUE) {
        return Int.MIN_VALUE
    } else if (control.toLong() > Int.MAX_VALUE) {
        return Int.MAX_VALUE
    }

    return control.toInt()

}

fun myAtoi(s: String): Int {

    if (s.isEmpty()) return 0
    val atoiInt = StringBuilder()
    var prefix: String? = null
    val stringList = s.split(" ")

    for (i in stringList.indices) {

        if (i.toString().isEmpty()) {
            continue
        }

        var currentString = stringList[i]
        if (prefix.isNullOrEmpty() && (currentString.startsWith("+") || currentString.startsWith("-"))) {
            prefix = currentString.first().toString()
            currentString = currentString.substring(1)
        }
        if (currentString.isNotEmpty() && !currentString.first().isDigit()) {
            val checkEmpty = if (atoiInt.toString().isEmpty()) 0 else atoiInt.toString().toInt()
            val prefixCheck = if (prefix == "-") -1 else 1
            return if (prefix.isNullOrEmpty()) checkEmpty else prefixCheck * checkEmpty

        }

        for (index in currentString.indices) {
            if (currentString[index].isDigit()) {
                atoiInt.append(currentString[index])
            } else {
                val prefixCheck = if (prefix == "-") -1 else 1
                val checkEmpty = if (atoiInt.toString().isEmpty()) 0 else atoiInt.toString().toInt()
                return if (prefix.isNullOrEmpty()) atoiInt.toString()
                    .toInt() else prefixCheck * checkEmpty
            }
        }

    }

    val prefixCheck = if (prefix == "-") -1 else 1
    val checkEmpty = if (atoiInt.toString().isEmpty()) 0 else atoiInt.toString().toLong()
    val control = if (prefix.isNullOrEmpty()) checkEmpty else prefixCheck * checkEmpty

    if (atoiInt.toString().isEmpty()) {
        return 0
    } else if (Int.MIN_VALUE > control) {
        return Int.MIN_VALUE
    } else if (control > Int.MAX_VALUE) {
        return Int.MAX_VALUE
    }

    return (prefixCheck * checkEmpty).toInt()
}

fun myAtoi1234(input: String): Int {
    var sign = 1
    var result = 0
    var index = 0
    val n = input.length

    // Discard all spaces from the beginning of the input string.
    while (index < n && input[index] == ' ') {
        index++
    }

    // sign = +1, if it's positive number, otherwise sign = -1.
    if (index < n && input[index] == '+') {
        sign = 1
        index++
    } else if (index < n && input[index] == '-') {
        sign = -1
        index++
    }

    // Traverse next digits of input and stop if it is not a digit
    while (index < n && Character.isDigit(input[index])) {
        val digit = input[index] - '0'

        // Check overflow and underflow conditions.
        if (result > Int.MAX_VALUE / 10 ||
            result == Int.MAX_VALUE / 10 && digit > Int.MAX_VALUE % 10
        ) {
            // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
            return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
        }

        // Append current digit to the result.
        result = 10 * result + digit
        index++
    }

    // We have formed a valid number without any overflow/underflow.
    // Return it after multiplying it with its sign.
    return sign * result
}
