package com.example.hackerranksolutions.leet

import java.util.*

fun main() {
    kWeakestRows(
        arrayOf(
            intArrayOf(1, 1, 0, 0, 0),
            intArrayOf(1, 1, 1, 1, 0),
            intArrayOf(1, 0, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 0),
            intArrayOf(1, 1, 1, 1, 1)
        ), 3
    )
}

fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
    val hashMap: HashMap<Int, Int> = HashMap()

    for (row in mat.indices) {
        var soilder = 0
        for (element in mat[row]) {
            if (element == 1) soilder++
        }
        hashMap[row] = soilder
    }

    val list: MutableList<Int> = ArrayList()

    return list.toIntArray()
}
