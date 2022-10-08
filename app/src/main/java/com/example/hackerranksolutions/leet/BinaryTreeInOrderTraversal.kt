package com.example.hackerranksolutions.leet

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.right = TreeNode(3)

    val result = inorderTraversal(root)
    println(result.joinToString("\n"))

}

fun inorderTraversal(root: TreeNode?): List<Int> {

    val res: MutableList<Int> = ArrayList()
    val stack: Stack<TreeNode> = Stack()

    var curr = root
    while (curr != null || stack.isNotEmpty()) {

        while (curr != null) {
            stack.push(curr)
            curr = curr.left
        }

        curr = stack.pop()
        res.add(curr.`val`)
        curr = curr.right

    }
    return res

}