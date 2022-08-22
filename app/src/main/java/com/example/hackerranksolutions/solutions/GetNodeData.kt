package com.example.hackerranksolutions.solutions

fun main() {
    val doneDate= SinglyLinkedListNode(2)
    println(getNode(doneDate,2))
}

fun getNode(listNode: SinglyLinkedListNode?, positionFromTail: Int): Int {
    var curr: SinglyLinkedListNode? = listNode
    var runner: SinglyLinkedListNode? = listNode

    /* Move runner into the list by k elements */
    for (i in 0 until positionFromTail) {
        runner = runner?.next
    }

    /* Move both pointers */
    while (runner?.next != null) {
        curr = curr?.next
        runner = runner.next
    }
    return curr?.data ?: 0
}

class SinglyLinkedListNode(nodeData: Int) {
     var data: Int
     var next: SinglyLinkedListNode?

    init {
        data = nodeData
        next = null
    }
}

