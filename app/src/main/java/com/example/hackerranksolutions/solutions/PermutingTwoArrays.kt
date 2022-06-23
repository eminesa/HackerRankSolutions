package com.example.hackerranksolutions.solutions

fun main() {

println(twoArrays(1, arrayOf(0,1), arrayOf(0,2)))

}

fun twoArrays(k: Int, A: Array<Int>, B: Array<Int>): String {

    var isQueries = "YES"

    for (index in A.indices) {
        if (A[index] + B[index] < k) {
            isQueries = "NO"
        }
    }

    return isQueries
}
