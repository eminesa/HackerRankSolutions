package com.example.hackerranksolutions.leet


fun main() {

    val obj = Solution1(intArrayOf(2,4,5,7,8,9,9))
    println(obj.pickIndex())

}

internal class Solution1(w: IntArray) {
    private val prefixSums: IntArray = IntArray(w.size)
    private val totalSum: Int
    fun pickIndex(): Int {
        val target = totalSum * Math.random()

        // run a binary search to find the target zone
        var low = 0
        var high = prefixSums.size
        while (low < high) {
            // better to avoid the overflow
            val mid = low + (high - low) / 2
            if (target > prefixSums[mid]) low = mid + 1 else high = mid
        }
        return low
    }

    init {
        var prefixSum = 0
        for (i in w.indices) {
            prefixSum += w[i]
            prefixSums[i] = prefixSum
        }
        totalSum = prefixSum
    }
}
