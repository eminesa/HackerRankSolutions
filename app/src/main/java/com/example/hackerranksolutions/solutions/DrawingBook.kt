package com.example.hackerranksolutions.solutions

fun main() {
    println(pageCount(6, 2))
}

fun pageCount(n: Int, p: Int): Int {

    return if (n == 2)
        0
    else if (n % 2 == 0 && n - p == 1)
        1
    else {
        //Returns the smaller of two values.
        //If either value is NaN, then the result is NaN.
        Math.min(p / 2, (n - p) / 2)
    }

}
