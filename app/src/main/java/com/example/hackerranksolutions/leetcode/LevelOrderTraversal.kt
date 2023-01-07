package com.example.hackerranksolutions.leetcode

import java.util.ArrayList


fun main() {

    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.right = TreeNode(3)

    val levelOrder = LevelOrder()
    val result = levelOrder.levelOrder(root)
    println(result.joinToString("\n"))
}


class LevelOrder {
    var levels: MutableList<MutableList<Int>> = ArrayList()
    fun helper(node: TreeNode?, level: Int) {
        // start the current level
        if (levels.size == level) levels.add(ArrayList())

        // fulfil the current level
        levels[level].add(node!!.`val`)

        // process child nodes for the next level
        if (node.left != null) helper(node.left, level + 1)
        if (node.right != null) helper(node.right, level + 1)
    }

    fun levelOrder(root: TreeNode?): List<MutableList<Int>> {
        if (root == null) return levels
        helper(root, 0)
        return levels
    }
}