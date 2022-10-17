package com.example.hackerranksolutions.leet

import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
     var obj = MovingAverage(4)
     val obj_one = obj.next(1)
  }

class MovingAverage(var size: Int) {
    private var windowSum = 0
    private var count = 0
    private var queue: Deque<Int> = java.util.ArrayDeque()
    fun next(`val`: Int): Double {
        ++count
        // calculate the new sum by shifting the window
        queue.add(`val`)
        val tail = if (count > size) queue.poll() else 0
        windowSum = windowSum - tail + `val`
        return windowSum * 1.0 / Math.min(size, count)
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * var obj = MovingAverage(size)
 * var param_1 = obj.next(`val`)
 */