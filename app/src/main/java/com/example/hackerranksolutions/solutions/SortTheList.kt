package com.example.hackerranksolutions.solutions

fun main() {
    val result = sortTheList(arrayOf(4, 5, 6, 7, 0))
    println(result.joinToString("\n"))
}

fun sortTheList(array: Array<Int>): Array<Int> {

    val listToBeUsed: MutableList<Int> = array.toMutableList()
    val sortedList = mutableListOf<Int>()

    while (listToBeUsed.size > 0) {
        var removeIndex = 0
        var minValue = listToBeUsed.first()

        listToBeUsed.mapIndexed { index, i ->
            if (i < minValue) {
                minValue = i
                removeIndex = index /*could change the min value*/
            }
        }

        listToBeUsed.removeAt(removeIndex)
        sortedList.add(minValue)

    }

    return sortedList.toTypedArray()
}

