package com.example.hackerranksolutions.leet

fun main() {
//[5,4,6,null,null,3,7]
    //5,1,4,null,null,3,6
    /*val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.right = TreeNode(3) */

    // [5,4,6,null,null,3,7]
    val root = TreeNode(5)
    root.left = TreeNode(3)
    // root.left?.left= TreeNode(null)
    // root.left?.right= TreeNode(null)
    root.right = TreeNode(7)
    root.right?.right = TreeNode(9)
    root.right?.left = TreeNode(6)

    println(isValidBST(root))

}

fun isValidBST(root: TreeNode?): Boolean {
    return isValidNode(root)
}

fun isValidNode(root: TreeNode?): Boolean {

    if (root?.left != null) {
        val left = root.left
        if (left != null) {
            if (left.`val` < root.`val`)
                isValidNode(root.left)
            else {
                return false
            }

        }
    }

    if (root?.right != null) {
        val right = root.right
        if (right?.`val` != null && right.`val` > root.`val`) {
            isValidNode(right)
        } else {
            return false
        }
    }

    return true
}
