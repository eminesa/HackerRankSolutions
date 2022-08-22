package com.example.hackerranksolutions.leet

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.right = TreeNode(3)

    findLeaves(root)

}
// idea: DFS
fun findLeaves(root: TreeNode?): List<List<Int?>> {
    val result: MutableList<List<Int?>> = ArrayList()
    while (true) {
        // in each iteration we delete all leaves
        val leaves: MutableList<Int?> = ArrayList()
        val rootIsLeaf = DFS(root, leaves)
        result.add(leaves)
        if (rootIsLeaf) {
            // finish processing the whole tree
            return result
        }
    }
}

// DFS, return true if node is a leaf
fun DFS(node: TreeNode?, lst: MutableList<Int?>): Boolean   {
    // base case: when this is null, it's not a leaf, return false
    if (node == null) {
        return false
    }

    // base case 2: when this is a leaf node, return true so that parent can remove
    if (node.left == null && node.right == null) {
        // leaf node! add it to list
        lst.add(node.`val`)
        return true
    }
    val leftIsLeaf = DFS(node.left, lst)
    val rightIsLeaf = DFS(node.right, lst)

    // remove the nodes where DFS returns true on (they are leaves!)
    if (leftIsLeaf) {
        node.left = null
    }
    if (rightIsLeaf) {
        node.right = null
    }

    // return false because we just want to remove one layer
    // of leafs in each iteration at main
    // So node shouldn't be remove at this iteration (though it might be a new leaf now)
    return false
}

