package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {

    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)

    val treeNode = TreeNode(3)
    treeNode.left = TreeNode(9)
    treeNode.right = TreeNode(20)
    treeNode.right?.left = TreeNode(15)
    treeNode.right?.right = TreeNode(7)

    println(sumOfLeftLeaves(root))
    println(sumOfLeftLeaves(treeNode))

}

fun sumOfLeftLeaves1(root: TreeNode?): Int {

    //keep left leave getting left leave

    //  if (root?.left == null && root?.right?.left == null) return 0

    val stack: Stack<TreeNode> = Stack()
    var sumOfLeft = 0

    var curr = root
    while (curr != null || stack.isNotEmpty()) {

        while (curr != null) {
            stack.push(curr)
            curr = curr.left
            if (curr != null && curr.left == null){
                sumOfLeft += curr.`val`
            }
        }

        curr = stack.pop()
        curr = curr.right

    }
    return sumOfLeft
}

private var sum = 0
fun sumOfLeftLeaves(root: TreeNode?): Int {
    helper(root, null)
    return sum
}

private fun helper(root: TreeNode?, p: TreeNode?) {
    if (root == null) return
    if (root.left == null && root.right == null && p != null && p.left == root) sum += root.`val`
    helper(root.left, root)
    helper(root.right, root)
}
