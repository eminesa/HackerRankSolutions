package com.example.hackerranksolutions.leet

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


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
    val weakestList: MutableList<Int> = ArrayList()

    for (row in mat.indices) {
        var count = 0
        for (element in mat[row]) {
            if (element == 1) {
                count += 1
            }
        }
        hashMap[row] = count
    }

    return intArrayOf()

}

@RequiresApi(Build.VERSION_CODES.N)
fun kWeakestRows123(mat: Array<IntArray>, k: Int): IntArray {
    val q: PriorityQueue<IntArray> = PriorityQueue { a, b ->
        if (a[0] != b[0]) a[0] - b[0] else a[1] - b[1]
    }
    var pos = 0
    for (row in mat) {
        var lo = 0
        var hi = row.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (row[mid] != 0) lo = mid + 1 else hi = mid
        }
        q.add(intArrayOf(lo, pos++))
    }
    val output = IntArray(k)
    for (i in 0 until k) output[i] = q.remove().get(1)
    return output
}