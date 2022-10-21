package com.example.hackerranksolutions.leet

import java.util.Stack

fun main() {
    println(findCenter(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(4, 2))))
}

fun findCenter(edges: Array<IntArray>): Int {

    val queue: Stack<Int> = Stack()

    queue.push(edges.first()[0])
    queue.push(edges.first()[1])

    for (index in 1 until edges.size) {
        if (queue.isNotEmpty()) {
            val firstEdge = queue.pop()
            if (edges[index][0] == firstEdge) {
                queue.clear()
                queue.push(edges[index][0])
            } else if (edges[index][1] == firstEdge) {
                queue.clear()
                queue.push(edges[index][1])
            }
        }
    }
    return queue.pop()
}