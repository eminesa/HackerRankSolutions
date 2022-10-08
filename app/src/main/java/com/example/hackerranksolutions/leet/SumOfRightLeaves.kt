package com.example.hackerranksolutions.leet

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

    println(sumOfRightLeaves(root))
    println(sumOfRightLeaves(treeNode))

}

private var sum: Int = 0
fun sumOfRightLeaves(root: TreeNode?): Int {
    sum = 0

    helperRight(root, null)

    return sum
}

fun helperRight(root: TreeNode?, p: TreeNode?) {

    if (root == null) return
    if (root.left == null && root.right == null && p != null && p.right == root) sum += root.`val`

    helperRight(root.right, root)
    helperRight(root.left, root)
}