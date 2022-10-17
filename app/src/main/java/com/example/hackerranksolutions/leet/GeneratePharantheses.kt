package com.example.hackerranksolutions.leet

fun main() {
    val result = generateParenthesis(3)
    println(result.joinToString(", "))
}

fun generateParenthesis(n: Int): List<String?> {
    val ans: MutableList<String?> = ArrayList()
    backtrack(ans, StringBuilder(), 0, 0, n)
    return ans
}

fun backtrack(ans: MutableList<String?>, cur: StringBuilder, open: Int, close: Int, max: Int) {
    if (cur.length == max * 2) {
        ans.add(cur.toString())
        return
    }
    if (open < max) {
        cur.append("(")
        backtrack(ans, cur, open + 1, close, max)
        cur.deleteCharAt(cur.length - 1)
    }
    if (close < open) {
        cur.append(")")
        backtrack(ans, cur, open, close + 1, max)
        cur.deleteCharAt(cur.length - 1)
    }
}
