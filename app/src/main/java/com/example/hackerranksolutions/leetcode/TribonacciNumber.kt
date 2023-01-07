package com.example.hackerranksolutions.leetcode

fun main() {
    println(tribonacci(4))
    println(tribonacci(25))
}

fun tribonacci(n: Int): Int {

    if (n == 0) return 0
    if (n == 1 || n == 2) return 1

    val tribonacciList: MutableList<Int> = ArrayList()
    tribonacciList.add(0)
    tribonacciList.add(1)
    tribonacciList.add(1)
    var tribonacci = 1
    var index = 2
    while (index < n) {
        tribonacci = tribonacciList[index] + tribonacciList[index - 1] + tribonacciList[index - 2]
        tribonacciList.add(tribonacci)
        index++
    }
    return tribonacci
}