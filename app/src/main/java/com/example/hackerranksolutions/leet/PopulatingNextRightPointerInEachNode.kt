package com.example.hackerranksolutions.leet

fun main() {

    val root = BinaryNode(1)
    root.left = BinaryNode(2)
    root.left?.left = BinaryNode(4)
    root.left?.right = BinaryNode(5)
    root.right = BinaryNode(3)
    root.right?.left = BinaryNode(6)
    root.right?.right = BinaryNode(7)

    connect(root)
}

class BinaryNode(var `val`: Int) { //for binary tree
    var left: BinaryNode? = null
    var right: BinaryNode? = null
    var next: BinaryNode? = null
}

// Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}

fun connect(root: BinaryNode?): BinaryNode? {

    if (root == null) {
        return root
    }

    // Start with the root node. There are no next pointers
    // that need to be set up on the first level
    var leftmost = root

    // Once we reach the final level, we are done
    while (leftmost?.left != null) {

        // Iterate the "linked list" starting from the head
        // node and using the next pointers, establish the
        // corresponding links for the next level
        var head = leftmost
        while (head != null) {

            // CONNECTION 1
            head.left!!.next = head.right

            // CONNECTION 2
            if (head.next != null) {
                head.right!!.next = head.next!!.left
            }

            // Progress along the list (nodes on the current level)
            head = head.next
        }

        // Move onto the next level
        leftmost = leftmost.left
    }
    return root
}