package com.example.hackerranksolutions.leet

fun main() {
    println(convert("PAYPALISHIRING", 3))
}

fun convert(s: String, numRows: Int): String {

    if (numRows == 1) return s
    val rows: MutableList<StringBuilder> = ArrayList()

    for (i in 0 until Math.min(numRows, s.length)) rows.add(StringBuilder())

    var curRow = 0
    var goingDown = false

    for (c in s.toCharArray()) {
        rows[curRow].append(c)
        if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown
        curRow += if (goingDown) 1 else -1
    }
    val ret = StringBuilder()
    for (row in rows) ret.append(row)
    return ret.toString()
}
