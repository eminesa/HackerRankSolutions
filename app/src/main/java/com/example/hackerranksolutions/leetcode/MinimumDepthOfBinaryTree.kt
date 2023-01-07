package com.example.hackerranksolutions.leetcode

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.right = TreeNode(4)
    root.right = TreeNode(3)

    println(minDepth(root))
}

fun minDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    if (root.left == null && root.right == null) {
        return 1
    }
    var minDepth = Int.MAX_VALUE
    if (root.left != null) {
        minDepth = Math.min(minDepth(root.left), minDepth)
    }
    if (root.right != null) {
        minDepth = Math.min(minDepth(root.right), minDepth)
    }
    return minDepth + 1
}