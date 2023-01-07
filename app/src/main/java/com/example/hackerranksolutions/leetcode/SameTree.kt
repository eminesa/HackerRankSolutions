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

    println(isSameTree(root, root2))
}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    // p and q are both null
    if (p == null && q == null) return true
    // one of p and q is null
    if (q == null || p == null) return false
    return if (p.`val` != q.`val`) false
    else isSameTree(p.right, q.right) && isSameTree(p.left, q.left)
}
