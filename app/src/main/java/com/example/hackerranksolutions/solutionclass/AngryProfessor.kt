package com.example.hackerranksolutions.solutionclass

fun main() {
    angryProfessor(3, arrayOf(-2,-1,0,1,2))
}

fun angryProfessor(k: Int, a: Array<Int>): String {

    val goOn = a.count { student -> student <= 0 }

    return if (goOn < k) {
        "YES"
    } else {
        "NO"
    }

}