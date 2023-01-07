package com.example.hackerranksolutions.leetcode

fun main() {
    val result = countBits(2)
    println(result.joinToString(", "))
}
fun countBits(n: Int): IntArray {
    val ans = IntArray(n + 1)
    var x = 0
    var b = 1

    // [0, b) is calculated
    while (b <= n) {
        // generate [b, 2b) or [b, n) from [0, b)
        while (x < b && x + b <= n) {
            ans[x + b] = ans[x] + 1
            ++x
        }
        x = 0 // reset x
        b = b shl 1 // b = 2b
    }
    return ans
}
fun countBits1(n: Int): IntArray {
    val ans = IntArray(n + 1)
    for (x in 1..n) {
        // x / 2 is x >> 1 and x % 2 is x & 1
        ans[x] = ans[x shr 1] + (x and 1)
    }
    return ans
}