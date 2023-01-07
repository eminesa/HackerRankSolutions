package com.example.hackerranksolutions.leetcode

fun main() {
    val listNode = ListNode(1)
    //  listNode.next = ListNode(2)
    // listNode.next?.next = ListNode(3)
    // listNode.next?.next?.next = ListNode(4)
    // listNode.next?.next?.next?.next = ListNode(5)

    removeNthFromEnd(listNode, 1)
}

fun removeNthFromStart(head: ListNode?, n: Int): ListNode? {

    var currentHead = head
    val splitList = "email".split("@")
    val removedNodeHead = ListNode(0)
    val listOfNode: MutableList<Int> = ArrayList()
    while (currentHead != null) {
        listOfNode.add(currentHead.`val`)
        currentHead = currentHead.next
    }
    currentHead = removedNodeHead
    for (index in listOfNode.indices) {
        if (index != n) {
            currentHead?.next = ListNode(listOfNode[index])
            currentHead = currentHead?.next
        }
    }
    return removedNodeHead.next
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

    var currentHead = head
    val removedNodeHead = ListNode(0)
    val listOfNode: MutableList<Int> = ArrayList()
    while (currentHead != null) {
        listOfNode.add(currentHead.`val`)
        currentHead = currentHead.next
    }
    currentHead = removedNodeHead
    val size = listOfNode.size - n  // 1,2,3,4,5
    for (index in listOfNode.indices) {
        if (index != size) {
            currentHead?.next = ListNode(listOfNode[index])
            currentHead = currentHead?.next
        }
    }
    return removedNodeHead.next
}

