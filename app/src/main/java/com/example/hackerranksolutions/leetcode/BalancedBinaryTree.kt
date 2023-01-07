package com.example.hackerranksolutions.leetcode

fun main() {

    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.right = TreeNode(4)
    root.right = TreeNode(3)

    println(isBalanced(root))
}

// Recursively obtain the height of a tree. An empty tree has -1 height
private fun height(root: TreeNode?): Int {
    // An empty tree has height -1
    return if (root == null) {
        -1
    } else 1 + Math.max(height(root.left), height(root.right))
}

fun isBalanced(root: TreeNode?): Boolean {
    // An empty tree satisfies the definition of a balanced tree
    return if (root == null) {
        true
    } else Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left)
            && isBalanced(root.right)

    // Check if subtrees have height within 1. If they do, check if the
    // subtrees are balanced
}