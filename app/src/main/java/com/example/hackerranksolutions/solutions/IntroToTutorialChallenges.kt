package com.example.hackerranksolutions.solutions

fun main() {
    println(introTutorial(3, arrayOf(1,2,3)))
}

fun introTutorial(V: Int, arr: Array<Int>): Int {

    var index = 0

    for (i in arr.indices){
        if (V == arr[i]){
            index = i
            break
        }
    }
    return index
}


