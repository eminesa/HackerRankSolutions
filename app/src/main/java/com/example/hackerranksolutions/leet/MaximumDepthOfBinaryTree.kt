package com.example.hackerranksolutions.leet

import java.util.*

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left?.left = TreeNode(3)
    root.left?.left?.left = TreeNode(5)
    //root.right?.right = TreeNode(3)
   // root.left?.right = TreeNode(4)
    //root.right?.left = TreeNode(4)

    println(maxDepth(root))
}

fun maxDepth(root: TreeNode?): Int {
    var updateRoot = root

    val linkedList: LinkedList<TreeNode?> = LinkedList()
    val depths: LinkedList<Int> = LinkedList()

    if (updateRoot == null) return 0

    linkedList.add(updateRoot)
    depths.add(1)

    var depth = 0
    var currentDepth: Int
    while (!linkedList.isEmpty()) {
        updateRoot = linkedList.pollLast()
        currentDepth = depths.pollLast() as Int
        if (updateRoot != null) {
            depth = Math.max(depth, currentDepth)
            linkedList.add(updateRoot.left)
            linkedList.add(updateRoot.right)
            depths.add(currentDepth + 1)
            depths.add(currentDepth + 1)
        }
    }
    return depth
}


