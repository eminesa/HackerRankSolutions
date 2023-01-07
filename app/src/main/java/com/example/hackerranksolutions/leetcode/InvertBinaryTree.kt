package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.right = TreeNode(3)

    invertTree(root)
}

fun invertTree1(root: TreeNode?): TreeNode? {

    if (root == null) return root

    val right = invertTree(root.right)
    val left = invertTree(root.left)

    root.right = left
    root.left = right
    return root
}

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)
    while (!queue.isEmpty()) {
        val current: TreeNode = queue.poll() as TreeNode
        val temp = current.left
        current.left = current.right
        current.right = temp
        if (current.left != null) queue.add(current.left)
        if (current.right != null) queue.add(current.right)
    }
    return root
}
