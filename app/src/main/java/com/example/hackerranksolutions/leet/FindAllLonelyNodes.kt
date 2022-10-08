package com.example.hackerranksolutions.leet

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.right = TreeNode(4)
    root.right = TreeNode(3)

    val result = getLonelyNodes(root)
    println(result.joinToString(" "))
}

fun getLonelyNodes(root: TreeNode?): List<Int> {

    val list: MutableList<Int> = ArrayList()
    helper(root, list)
    return list
}

fun helper(node: TreeNode?, list: MutableList<Int>) {

    if (node == null) return

  //  if (node.left == null && node.right == null) list.add(node.`val`)
    if (node.right != null && node.left == null) list.add(node.right?.`val` ?: 0)
    if (node.right == null && node.left != null) list.add(node.left?.`val` ?: 0)

    helper(node.right, list)
    helper(node.left, list)
}



