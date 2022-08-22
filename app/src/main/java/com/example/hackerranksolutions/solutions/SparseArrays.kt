package com.example.hackerranksolutions.solutions

fun main() {

    val result = matchingStrings(arrayOf("aba", "baba", "aba", "xzxb"), arrayOf("aba", "xzxb", "ab"))

    println(result.joinToString("\n"))
}

/*
foreach iterates over a list and performs some operation with side effects to each list member
(such as saving each one to the database for example)

map iterates over a list,
transforms each member of that list,
and returns another list of the same size with the transformed members
(such as converting a list of strings to uppercase)
 */

fun matchingStrings(strings: Array<String>, queries: Array<String>): Array<Int> {
    val returnToStringList = mutableListOf<Int>()

    queries.map { query ->
        val countOfType = strings.count { query == it }
        returnToStringList.add(countOfType)
    }

    return returnToStringList.toTypedArray()
}