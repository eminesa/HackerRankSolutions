package com.example.hackerranksolutions.leetcode

fun main() {
    val result = generateParenthesis1(3)
    println(result.joinToString(" "))
}
fun generateParenthesis1(n: Int): List<String> {
    val ans: MutableList<String> = ArrayList()
    if (n == 0) {
        ans.add("")
    } else {
        for (c in 0 until n) for (left in generateParenthesis(c)) for (right in generateParenthesis(
            n - 1 - c
        )) ans.add(
            "($left)$right"
        )
    }
    return ans
}