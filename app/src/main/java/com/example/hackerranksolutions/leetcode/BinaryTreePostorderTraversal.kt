package com.example.hackerranksolutions.leetcode

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.right = TreeNode(4)
    root.right = TreeNode(3)

    val result = postorderTraversal(root)

    println(result.joinToString(", "))
}

fun postorderTraversal(root: TreeNode?): List<Int> {
    val postList: MutableList<Int> = ArrayList()
    orderList(root, postList)
    return postList.reversed()
}

fun orderList(root: TreeNode?, orderList: MutableList<Int>) {

    if (root == null) return

    orderList.add(root.`val`)

    orderList(root.right, orderList)
    orderList(root.left, orderList)
}