package com.example.hackerranksolutions.solutionclass

fun main() {
    println(pangrams("We promptly judged antique ivory buckles for the next prize"))
    println(pangrams1("We promptly judged antique ivory buckles for the next prize"))
}

fun pangrams(s: String): String {

    var pangrams = "pangram"
    val alphabetWithUpperAndSpace = "abcdefghijklmnopqrstuvwxyz" + " "

    val sentenceOfChar = s.toLowerCase().toCharArray()

    for (letter in alphabetWithUpperAndSpace) {
        if (!sentenceOfChar.contains(letter)) {
            pangrams = "not pangram"
            break
        }
    }

    return pangrams
}

fun pangrams1(s: String): String {

    var pangrams = "pangram"
    val alphabetWithSpace = "abcdefghijklmnopqrstuvwxyz" + " "
   /** hackerrank lower case yapmamız için kullandığımız bu fonksiyonu kabul etmiyor
    * lowercase() yerine toLowerCase() kullanmamızı istiyor.
    * Kotlinde bu fonksiyon deprecated oldu. */
    val sentenceOfChar = s.lowercase().toCharArray()
    repeat(alphabetWithSpace.filter { !sentenceOfChar.contains(it) }.length) {
        pangrams = "not pangram"
    }

    return pangrams
}