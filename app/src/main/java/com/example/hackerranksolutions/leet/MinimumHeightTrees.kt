package com.example.hackerranksolutions.leet

fun main() {

    val result =
        findMinHeightTrees(4, arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(1, 3)))

    println(result.joinToString(" "))
}

fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {

    // edge cases
    if (n < 2) {
        val centroids: ArrayList<Int> = ArrayList()
        for (i in 0 until n) centroids.add(i)
        return centroids
    }

    // Build the graph with the adjacency list
    val neighbors: ArrayList<MutableSet<Int>> = ArrayList()
    for (i in 0 until n) neighbors.add(HashSet())
    for (edge in edges) {
        val start = edge[0]
        val end = edge[1]
        neighbors[start].add(end)
        neighbors[end].add(start)
    }

    // Initialize the first layer of leaves
    var leaves: ArrayList<Int> = ArrayList()
    for (i in 0 until n) if (neighbors[i].size == 1) leaves.add(i)

    // Trim the leaves until reaching the centroids
    var remainingNodes = n
    while (remainingNodes > 2) {
        remainingNodes -= leaves.size
        val newLeaves: ArrayList<Int> = ArrayList()

        // remove the current leaves along with the edges
        for (leaf in leaves) {
            // the only neighbor left for the leaf node
            val neighbor = neighbors[leaf].iterator().next()
            // remove the edge along with the leaf node
            neighbors[neighbor].remove(leaf)
            if (neighbors[neighbor].size == 1) newLeaves.add(neighbor)
        }

        // prepare for the next round
        leaves = newLeaves
    }

    // The remaining nodes are the centroids of the graph
    return leaves
}

