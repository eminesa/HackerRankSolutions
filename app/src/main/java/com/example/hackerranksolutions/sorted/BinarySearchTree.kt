package com.example.hackerranksolutions.sorted

internal class BST_class     // Constructor for BST =>initial empty tree
{
    //node class that defines BST node
    internal inner class Node(var key: Int) {
        var left: Node?
        var right: Node? = null

        init {
            left = right
        }
    }

    // BST root node
    var root: Node? = null

    //delete a node from BST
    fun deleteKey(key: Int) {
        root = delete_Recursive(root, key)
    }

    //recursive delete function
    fun delete_Recursive(root: Node?, key: Int): Node? {
        //tree is empty
        if (root == null) return root

        //traverse the tree
        if (key < root.key) //traverse left subtree
            root.left =
                delete_Recursive(root.left, key) else if (key > root.key) //traverse right subtree
            root.right = delete_Recursive(root.right, key) else {
            // node contains only one child
            if (root.left == null) return root.right else if (root.right == null) return root.left

            // node has two children;
            //get inorder successor (min value in the right subtree)
            root.key = minValue(root.right)

            // Delete the inorder successor
            root.right = delete_Recursive(root.right, root.key)
        }
        return root
    }

    fun minValue(root: Node?): Int {
        //initially minval = root
        var currentRoot = root
        var minval = currentRoot!!.key
        //find minval
        while (currentRoot!!.left != null) {
            minval = currentRoot.left!!.key
            currentRoot = currentRoot.left
        }
        return minval
    }

    // insert a node in BST
    fun insert(key: Int) {
        root = insert_Recursive(root, key)
    }

    //recursive insert function
    fun insert_Recursive(root: Node?, key: Int): Node {
        //tree is empty
        var currentRoot = root
        if (currentRoot == null) {
            currentRoot = Node(key)
            return currentRoot
        }
        //traverse the tree
        if (key < currentRoot.key) //insert in the left subtree
            currentRoot.left = insert_Recursive(
                currentRoot.left,
                key
            ) else if (key > currentRoot.key) //insert in the right subtree
            currentRoot.right = insert_Recursive(currentRoot.right, key)
        // return pointer
        return currentRoot
    }

    // method for inorder traversal of BST
    fun inorder() {
        inorder_Recursive(root)
    }

    // recursively traverse the BST
    fun inorder_Recursive(root: Node?) {
        if (root != null) {
            inorder_Recursive(root.left)
            print(root.key.toString() + " ")
            inorder_Recursive(root.right)
        }
    }

    fun search(key: Int): Boolean {
        root = search_Recursive(root, key)
        return if (root != null) true else false
    }

    //recursive insert function
    fun search_Recursive(root: Node?, key: Int): Node? {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key) return root
        // val is greater than root's key
        return if (root.key > key) search_Recursive(
            root.left,
            key
        ) else search_Recursive(root.right, key)
        // val is less than root's key
    }
}

fun main() {
    //create a BST object
    val bst = BST_class()
    /* BST tree example
          45
       /     \
      10      90
     /  \    /   \
    7   12  50     97  */
    //insert data into BST
    bst.insert(45)
    bst.insert(10)
    bst.insert(7)
    bst.insert(12)
    bst.insert(90)
    bst.insert(50)
    //print the BST
    println("The BST Created with input data(Left-root-right):")
    bst.inorder()

    //delete leaf node
    println("\nThe BST after Delete 12(leaf node):")
    bst.deleteKey(12)
    bst.inorder()
    //delete the node with one child
    println("\nThe BST after Delete 90 (node with 1 child):")
    bst.deleteKey(90)
    bst.inorder()

    //delete node with two children
    println("\nThe BST after Delete 45 (Node with two children):")
    bst.deleteKey(45)
    bst.inorder()
    //search a key in the BST
    var ret_val = bst.search(50)
    println("\nKey 50 found in BST:$ret_val")
    ret_val = bst.search(12)
    println("\nKey 12 found in BST:$ret_val")
}