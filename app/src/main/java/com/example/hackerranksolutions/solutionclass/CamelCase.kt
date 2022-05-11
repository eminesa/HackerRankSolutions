package com.example.hackerranksolutions.solutionclass

fun main() {
   println( camelcase("tryIng"))
   println( camelcase1("tryIng"))
}

fun camelcase(s: String): Int {

    var total = 1
    val letterArray = s.toCharArray()

    for (letter in letterArray){
        if (letter.isUpperCase()){
            total += 1
        }
    }

    return total
}

fun camelcase1(s: String): Int {

    val upperCase = s.toCharArray().filter { letter -> letter.isUpperCase() }

    return upperCase.size +1
}

