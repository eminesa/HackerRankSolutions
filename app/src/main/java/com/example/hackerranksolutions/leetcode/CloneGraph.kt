package com.example.hackerranksolutions.leetcode

fun main() {
// [2,4],[1,3],[2,4],[1,3]
val node = Node(2)
    node.neighbors = ArrayList(4)
    cloneGraph(node)
}


fun cloneGraph(node: Node?): Node? {
    if (node == null) {
        return node
    }
    val visited: HashMap<Node, Node> = HashMap()
    // If the node was already visited before.
    // Return the clone from the visited dictionary.
    if (visited.containsKey(node)) {
        return visited[node]
    }

    // Create a clone for the given node.
    // Note that we don't have cloned neighbors as of now, hence [].
    val cloneNode = Node(node.`val`)
    // The key is original node and value being the clone node.
    visited[node] = cloneNode

    // Iterate through the neighbors to generate their clones
    // and prepare a list of cloned neighbors to be added to the cloned node.
    for (neighbor in node.neighbors) {
        cloneGraph(neighbor)?.let { cloneNode.neighbors.add(it) }
    }
    return cloneNode
}
