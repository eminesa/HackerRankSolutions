package com.example.hackerranksolutions.solutions

fun main() {

println(alternatingCharacters("ABBAAAABBA"))

}

fun alternatingCharacters(s: String): Int {

    val charList = s.toCharArray()
    var letterOfControl = '?'
    var deleteLetterSize = 0

    charList.map { letter ->

        when (letter) {
            letterOfControl -> {
                deleteLetterSize += 1
            }
            else -> {
                letterOfControl = letter
            }
        }
    }

    return deleteLetterSize
}
