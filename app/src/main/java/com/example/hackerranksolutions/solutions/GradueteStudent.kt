package com.example.hackerranksolutions.solutions

fun main() {

    val result = gradingStudents(arrayOf(73, 67, 38, 33))

    println(result.joinToString("\n"))

}

fun gradingStudents(grades: Array<Int>): Array<Int> {

    val updatedList = mutableListOf<Int>()

    for (grade in grades) {
        when {
            grade % 5 == 3 && grade >= 38 -> {
                updatedList.add(grade + 2)
            }
            grade % 5 == 4 && grade >= 38 -> {
                updatedList.add(grade + 1)
            }
            else -> {
                updatedList.add(grade)
            }
        }
    }

    return updatedList.toTypedArray()

}