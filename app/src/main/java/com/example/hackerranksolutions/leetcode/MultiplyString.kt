package com.example.hackerranksolutions.leetcode

fun main() {
    println(multiply("498828660196", "840477629533"))
}

fun multiply1(num1: String, num2: String): String {

    //Both num1 and num2 do not contain any leading zero, except the number 0 itself.
    // num1 convert to Int
    val number1 = num1.toLong()

    // num2 convert to Int
    val number2 = num2.toLong()

    // get multiply of them
    val result = number1 * number2

    // return result as string
    return result.toString()
}

fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") {
        return "0"
    }
    val firstNumber = StringBuilder(num1)
    val secondNumber = StringBuilder(num2)

    // Reverse both the numbers.
    firstNumber.reverse()
    secondNumber.reverse()

    // To store the multiplication result of each digit of secondNumber with firstNumber.
    val sizeOfString = firstNumber.length + secondNumber.length
    val answer = StringBuilder()
    for (i in 0 until sizeOfString) {
        answer.append(0)
    }
    for (place2 in secondNumber.indices) {
        val digit2 = secondNumber[place2] - '0'

        // For each digit in secondNumber multiply the digit by all digits in firstNumber.
        for (place1 in firstNumber.indices) {
            val digit1 = firstNumber[place1] - '0'

            // The number of zeros from multiplying to digits depends on the
            // place of digit2 in secondNumber and the place of the digit1 in firstNumber.
            val currentPos = place1 + place2

            // The digit currently at position currentPos in the answer string
            // is carried over and summed with the current result.
            val carry = answer[currentPos] - '0'
            val multiplication = digit1 * digit2 + carry

            // Set the ones place of the multiplication result.
            answer.setCharAt(currentPos, (multiplication % 10 + '0'.toInt()).toChar())

            // Carry the tens place of the multiplication result by
            // adding it to the next position in the answer array.
            val value = answer[currentPos + 1] - "0".toInt() + multiplication / 10
            answer.setCharAt(currentPos + 1, (value + "0".toInt()).toChar())
        }
    }

    // Pop excess 0 from the rear of answer.
    if (answer[answer.length - 1] == '0') {
        answer.deleteCharAt(answer.length - 1)
    }
    answer.reverse()
    return answer.toString()
}
