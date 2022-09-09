package com.example.hackerranksolutions.leet

fun main() {
    println(reverseWords("Let's take LeetCode contest"))
}

fun reverseWords(s: String): String {

    var currentString = s.split(" ")
    currentString = currentString.toMutableList()
    val reversedString = StringBuilder()

    for (index in currentString.indices) {
        val word = currentString[index].toCharArray()
        var reverseWord = ""
        var startIndex = word.size - 1
        while (startIndex >= 0) {
            reverseWord += word[startIndex]
            startIndex--
        }
        if (index != currentString.size - 1)
            reversedString.append(reverseWord.plus(" "))
        else reversedString.append(reverseWord.plus(""))
    }

    return reversedString.toString()
}