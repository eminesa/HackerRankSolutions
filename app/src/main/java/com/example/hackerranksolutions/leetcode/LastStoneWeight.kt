package com.example.hackerranksolutions.leetcode

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    println(lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
    println(lastStoneWeight(intArrayOf(1)))
    println(lastStoneWeight(intArrayOf(1, 3)))
    println(lastStoneWeight(intArrayOf(7, 6, 7, 6, 9)))
    println(lastStoneWeight(intArrayOf(3, 7, 8)))
    println(lastStoneWeight(intArrayOf(9, 10, 1, 7, 3)))
}

fun lastStoneWeight111(stones: IntArray): Int {

    if (stones.isEmpty()) return 0
    if (stones.size == 1) return stones.first()

    Arrays.sort(stones)
    var stonesList = stones.toMutableList()

    while (stonesList.size > 1) {

        val index = stonesList.size - 1
        val y = stonesList[index]
        val x = stonesList[index - 1]
        if (y == x) {
            stonesList.removeAt(index)
            stonesList.removeAt(index - 1)
        } else {
            stonesList.removeAt(index)
            stonesList.removeAt(index - 1)
            stonesList.add(y - x)
            val sorted = stonesList.sorted()
            stonesList.clear()
            stonesList = sorted.toMutableList()
        }
    }

    return if (stonesList.isNotEmpty()) stonesList.first() else 0
}


@RequiresApi(Build.VERSION_CODES.N)
fun lastStoneWeight(stones: IntArray): Int {
    val queue: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
    for (i in stones) {
        queue.add(i)
    }
    var x: Int
    var y: Int
    while (queue.size > 1) {
        y = queue.poll()
        x = queue.poll()
        if (y > x) {
            queue.offer(y - x)
        }
    }
    return if (queue.isEmpty()) 0 else queue.poll()
}