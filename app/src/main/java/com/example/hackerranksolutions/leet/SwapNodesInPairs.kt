package com.example.hackerranksolutions.leet

fun main() {
    val listNode = ListNode(1)
    listNode.next = ListNode(2)
    listNode.next?.next = ListNode(2)
    listNode.next?.next?.next = ListNode(1)

    println(swapPairs(listNode))
}

fun swapPairs(head: ListNode?): ListNode? {

    // If the list has no node or has only one node left.
    if (head?.next == null) {
        return head
    }

    // Nodes to be swapped
    val firstNode: ListNode = head
    val secondNode = head.next

    // Swapping
    firstNode.next = swapPairs(secondNode!!.next)
    secondNode.next = firstNode

    // Now the head is the second node
    return secondNode
}
