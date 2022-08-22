package com.example.hackerranksolutions.solutions

fun main() {
    ///println(balancedSums(arrayOf(1, 1, 4, 1, 1)))
    //balancedSums(arrayOf(1, 1, 4, 1, 1))
    println(balancedSums(arrayOf(1, 2, 3, 4, 5)))
}

private fun balancedSums(arr: Array<Int>): String {
    val sum = arr.sum()

    var leftSum = 0

    for (i in arr.indices) {
        if (leftSum == sum - leftSum - arr[i]) {
            return "YES"
        }
        leftSum += arr[i]
    }
    return "NO"
}