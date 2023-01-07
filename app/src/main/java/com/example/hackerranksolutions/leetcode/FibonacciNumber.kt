package com.example.hackerranksolutions.leetcode

fun main() {
    println(fib(5))
}
//Örn: 0-1-1-2-3-5-8-13-bir Fibonacci Dizisidir.
fun fib(n: Int): Int {

    if (n == 0) return 0
    if (n == 1 || n == 2) return 1

    var currentNumber = n - 2
    var fibonacciNumber = 1
    var lastNumber = 1
    var temporary = 1
    while (currentNumber > 0) {

        fibonacciNumber = temporary + lastNumber
        temporary = lastNumber
        lastNumber = fibonacciNumber

        currentNumber--
    }

    return fibonacciNumber
}
