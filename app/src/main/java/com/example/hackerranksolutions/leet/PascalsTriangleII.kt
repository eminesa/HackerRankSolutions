package com.example.hackerranksolutions.leet

fun main() {
    val result = getRow(4)
    println(result.joinToString(" "))
}

fun getRow(rowIndex: Int): List<Int> {

    if (rowIndex == 0) return listOf(1)
    if (rowIndex == 1) return listOf(1, 1)

    val pascalTriangle: MutableList<List<Int>> = ArrayList()
    pascalTriangle.add(listOf(1))
    pascalTriangle.add(listOf(1, 1))

    var index = rowIndex
    while (index > 1) {
        val list: MutableList<Int> = ArrayList()
        list.add(1)

        val pascalLast = pascalTriangle.last()
        for (pascalIndex in 0 until pascalLast.size) {
            if (pascalIndex + 1 < pascalTriangle.last().size) {
                list.add(pascalLast[pascalIndex] + pascalLast[pascalIndex + 1])
            }
        }

        list.add(1)
        pascalTriangle.add(list)
        index -= 1
    }

    return pascalTriangle[rowIndex]
}