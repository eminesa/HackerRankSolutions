package com.example.hackerranksolutions.leet

fun main() {
    val result = generateParenthesis(3)
    println(result.joinToString(" "))
}
fun generateParenthesis(n: Int): List<String> {
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