package com.example.hackerranksolutions.leetcode

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.right = TreeNode(3)

    val root2 = TreeNode(1)
    root2.left = TreeNode(2)
    root2.left?.left = TreeNode(4)
    root2.left?.right = TreeNode(5)
    root2.right = TreeNode(3)

    mergeTrees(root, root2)
}

fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {

    if (root1 == null) return root2

    if (root2 == null) return root1

    root1.`val` += root2.`val` // ı sum with root1 val end root2 val and do it by itself add all result root1

    root1.left = mergeTrees(root1.left, root2.left)
    root1.right = mergeTrees(root1.right, root2.right)

    return root1
}
