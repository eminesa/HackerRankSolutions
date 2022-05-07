package com.example.hackerranksolutions.solutionclass

fun main(){
 print(catAndMouse(1,3,2))
}

fun catAndMouse(cat1: Int, cat2: Int, mouse: Int): String {

    val cat1Way = kotlin.math.abs(mouse - cat1)
    val cat2Way = kotlin.math.abs(mouse - cat2)

  val  result = when {
        cat1Way > cat2Way -> {
            "Cat B"
        }
        cat1Way < cat2Way -> {
            "Cat A"
        }
        else -> {
            "Mouse C"
        }
    }

    return result
}