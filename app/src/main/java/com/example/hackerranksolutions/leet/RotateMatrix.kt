package com.example.hackerranksolutions.leet


fun main() {
    /* val a = arrayOf(
         intArrayOf(1, 2, 3),
         intArrayOf(4, 5, 6),
         intArrayOf(7, 8, 9),
     ) */
    /*val a = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12),
        intArrayOf(13, 14, 15, 16)
    ) */

    /*  val a = arrayOf(
          intArrayOf(1, 2),
          intArrayOf(3, 4),
      ) */
    val a = arrayOf(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(6, 7, 8, 9, 10),
        intArrayOf(11, 12, 13, 14, 15),
        intArrayOf(16, 17, 18, 19, 20),
        intArrayOf(21, 22, 23, 23, 25),
    )
    val mat = rotateMatrix(a)

    for (element in mat) {
        for (j in 0 until mat[0].size) print(element[j].toString() + " ")
        print("\n")
    }

}

fun rotateMatrix(
    mat: Array<IntArray>
): Array<IntArray> {

    // I have 4 different list like
    // 1, 2, 3 -> 1th
    // 3, 6, 9 -> 2th
    // 9, 8, 7 -> 3th
    // 7, 4, 1 -> 4th
    // I will change one by one
    // every line take one  for loop
    // totally time complexity O(4n) if we have nxn matrix .
// if we have more than 2X2 our min n == 2
    // space complexity O(4n)

    if (mat.isEmpty() || mat.size < 2) return mat

    var previous = mat[1][0]
    var current: Int
    var row = 0
    var col = mat[0].size - 1

    for (index in 0 until mat[0].size) { //  1th list
        current = mat[row][index]
        mat[row][index] = previous
        previous = current
    }
    row += 1
    for (index in row until mat.size) { // 2th list
        current = mat[index][col]
        mat[index][col] = previous
        previous = current
    }

    row = mat.size - 1
    col -= 1
    for (index in col downTo 0) { // 3th list
        current = mat[row][index]
        mat[row][index] = previous
        previous = current
    }

    col = 0
    row = mat.size - 2
    for (index in row downTo 0) { // 4th list
        current = mat[index][col]
        mat[index][col] = previous
        previous = current
    }

    return mat
}