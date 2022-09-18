package com.example.hackerranksolutions.solutions

import java.lang.StringBuilder

fun main() {
    println(hackerrankInString("hereiamstackerrank"))
    println(hackerrankInString("hackerworld"))
    println(hackerrankInString("rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt"))
}

fun hackerrankInString1(s: String): String {
    var hackerrank = ""
    var setString = s

    "hackerrank".map { charOfHackerrank ->

        if (charOfHackerrank != 'h' && setString.isNotEmpty()){
           val changeString = setString.drop(1)
           setString = changeString
       }
        var startIndex = 0
        while (startIndex < setString.length) {

            if (setString[startIndex] == charOfHackerrank) {
                hackerrank = hackerrank.plus(charOfHackerrank)
                startIndex = s.length
            }
            startIndex++
        }

    }

    return if (hackerrank == "hackerrank") "YES" else "NO"
}


private fun hackerrankInString(s: String): String {
    val hackerrankString = "hackerrank"

    if (s.length < hackerrankString.length) {
        return "NO"
    }

    var index = 0
    for (element in s) {
        if (index < hackerrankString.length && element == hackerrankString[index]) {
            index++
        }
    }
    return if (index == hackerrankString.length) "YES" else "NO"
}