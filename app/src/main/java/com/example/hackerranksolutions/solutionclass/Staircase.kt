package com.example.hackerranksolutions.solutionclass

fun main() {

    staircase(4)
    staircase1(4)

}

fun staircase(n: Int): Unit {

    var star = "#"
    var space: String

    for (index in 1..n) {
        space = ""
        for (spaceSize in index until n) {
            space += " "
        }

        println(space + star)
        star += "#"
    }

}

fun staircase1(n: Int): Unit {

    var star = "#"
    var space: String

    for (index in 1..n) {

        space = " ".repeat(n - star.length)

        println(space.plus(star))

        star += "#"
    }

}