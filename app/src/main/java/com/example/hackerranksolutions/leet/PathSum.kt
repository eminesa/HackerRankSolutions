package com.example.hackerranksolutions.leet

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.right = TreeNode(4)
    root.right = TreeNode(3)

    println(hasPathSum(root, 3))
}

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false
    val sum = targetSum - root.`val`
    return if (root.left == null && root.right == null) sum == 0
    else hasPathSum(root.left, sum) || hasPathSum(root.right, sum)
}
