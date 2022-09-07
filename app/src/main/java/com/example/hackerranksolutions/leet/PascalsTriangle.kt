package com.example.hackerranksolutions.leet

fun main() {
    val result = generate(5)
    println(result.joinToString("\n"))
}

fun generate(numRows: Int): List<List<Int>> {
    val pascalList: MutableList<List<Int>> = arrayListOf(listOf(1))
    // All time came 1

    var index = 0
    while (index < numRows - 1) {
        val temporaryList: MutableList<Int> = ArrayList()
        if (index < 1) {
            temporaryList.add(1)
            temporaryList.add(1)

        } else {
            val checkList = pascalList.last()
            val checkListSize = checkList.size
            temporaryList.add(1)
            var sumIndex = 0
            while (sumIndex < checkListSize) {
                if (sumIndex + 1 < checkListSize) {
                    val sum = checkList[sumIndex] + checkList[sumIndex + 1]
                    temporaryList.add(sum)
                }
                sumIndex++
            }
            temporaryList.add(1)
        }

        pascalList.add(temporaryList)
        index++
    }

    return pascalList.toList()
}