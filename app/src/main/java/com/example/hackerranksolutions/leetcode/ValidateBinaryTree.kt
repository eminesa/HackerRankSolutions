package com.example.hackerranksolutions.leetcode

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
    root.left = TreeNode(4)
    root.right = TreeNode(6)
    //root.right?.left = TreeNode(3)
    root.right?.right = TreeNode(7)

    // root.left?.left= TreeNode(null)
    // root.right = TreeNode(7)
    //root.right?.right = TreeNode(9)
    //root.right?.left = TreeNode(6)

    println(isValidBST(root))

}

fun isValidBST(root: TreeNode?): Boolean {
    return isValidNode(root, root?.`val`)
}

fun isValidNode(
    root: TreeNode?,
    rootValue: Int?
): Boolean {  // not check for smaller than node or bigger than node.

    if (root == null) return false // should ask interviewer
    if (rootValue == null) return false

    val left = root.left
    val right = root.right

    if (left != null) {
        if ((right != null && rootValue < right.`val` )|| rootValue < left.`val`) return false
        if (left.`val` < root.`val`)
            isValidNode(left, rootValue)
        else {
            return false
        }
    }

    if (right != null) {
        if ((left != null &&  rootValue > left.`val` )  || rootValue > right.`val`) return false

        if (right.`val` > root.`val`) {
            isValidNode(right, rootValue)
        } else {
            return false
        }
    }

    return true
}

internal object GFG {
    var prev: TreeNode? = null
    fun isValidNode(root: TreeNode?): Boolean {
        // traverse the tree in inorder fashion and
        // keep track of prev node
        if (root != null) {
            if (!isValidNode(root.left)) return false

            // Allows only distinct valued nodes
            if (prev != null &&
                root.`val` <= prev!!.`val`
            ) return false
            prev = root
            return isValidNode(root.right)
        }
        return true
    }

}

//Java implementation to check if given Binary tree
//is a BST or not

//Java implementation to check if given Binary tree
//is a BST or not
/* Class containing left and right child of current
node and key value*/

class BinaryTree {
    //Root of the Binary Tree
    var root: TreeNode? = null

    /* can give min and max value according to your code or
      can write a function to find min and max value of tree. */
    /* returns true if given search tree is binary
          search tree (efficient version) */
    val isBST = isBSTUtil(root, Int.MIN_VALUE, Int.MAX_VALUE)

    /* Returns true if the given tree is a BST and its
      values are >= min and <= max. */
    fun isBSTUtil(node: TreeNode?, min: Int, max: Int): Boolean {
        /* an empty tree is BST */
        if (node == null) return true

        /* false if this node violates the min/max constraints */
        return if (node.`val` < min || node.`val` > max) false
        else isBSTUtil(node.left, min, node.`val` - 1) && isBSTUtil(node.right, node.`val` + 1, max)

        /* otherwise check the subtrees recursively
		tightening the min/max constraints */
        // Allow only distinct values
    }

    companion object {
        /* Driver program to test above functions */
        @JvmStatic
        fun main(args: Array<String>) {
            val tree = BinaryTree()
            tree.root = TreeNode(4)
            tree.root!!.left = TreeNode(2)
            tree.root!!.right = TreeNode(5)
            tree.root!!.left!!.left = TreeNode(1)
            tree.root!!.left!!.right = TreeNode(3)
            if (tree.isBST) println("IS BST") else println("Not a BST")
        }
    }
}



