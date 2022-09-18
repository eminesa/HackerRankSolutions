package com.example.hackerranksolutions.leet

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main() {
// [[0,1],[0,2],[3,5],[5,4],[4,3]]
    //[0,1],[0,2],[3,5],[5,4],[4,3]
    println(validPath(3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 0)), 0, 2))
    println(validPath(6, arrayOf(
        intArrayOf(0, 1),
        intArrayOf(2, 0),
        intArrayOf(3, 5),
        intArrayOf(5, 4),
        intArrayOf(4, 3)
    ), 0, 5))
}
/*
fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {

    //
    var isValid = false
    val size = edges.size - 1
    for (i in 0 until size) {

     //   if (edges[i][1] != destination) return false

        isValid = false
        val searchNode = edges[i][1]
        var j = 0
        while (j < size + 1) {

            if (edges[j][0] == searchNode) {
                j = size + 1
                isValid = true
            }
            j++
        }
    }
    return isValid
} */

fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {

    val edgeList: ArrayList<ArrayList<Int>> = ArrayList()

    for (i in 0 until n) edgeList.add(ArrayList())

    for (i in edges.indices) {
        edgeList[edges[i][0]].add(edges[i][1])
        edgeList[edges[i][1]].add(edges[i][0])
    }

    val q: Queue<Int> = LinkedList()
    val vis: HashSet<Int> = HashSet()
    q.add(source)

    while (!q.isEmpty()) {
        val u: Int = q.poll() as Int
        vis.add(u)
        if (u == destination) return true
        for (v in edgeList[u]) {
            if (!vis.contains(v)) {
                q.add(v)
            }
        }
    }

    return false
}

