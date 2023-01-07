package com.example.hackerranksolutions.leetcode


fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.right = TreeNode(3)

    val result = splitBST(root, 2)
    println(result.joinToString(" "))
}

fun splitBST(root: TreeNode?, target: Int): Array<TreeNode?> {
    return when {
        root == null -> arrayOf(null, null)
        root.`val` <= target -> {
            val bns = splitBST(root.right, target)
            root.right = bns[0]
            bns[0] = root
            bns
        }
        else -> {
            val bns = splitBST(root.left, target)
            root.left = bns[1]
            bns[1] = root
            bns
        }
    }
}
