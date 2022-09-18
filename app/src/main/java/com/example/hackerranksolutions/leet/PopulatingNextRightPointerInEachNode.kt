package com.example.hackerranksolutions.leet

fun main() {

   val root =Node(1)
   root.left = Node(2)
   root.left?.left = Node(4)
   root.left?.right = Node(5)
   root.right = Node(3)
   root.right?.left = Node(6)
   root.right?.right = Node(7)

    connect(root)
}

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

fun connect(root: Node?): Node? {

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