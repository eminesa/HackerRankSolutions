package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {
    val listNode = ListNode(2)
    listNode.next = ListNode(3)
    listNode.next?.next = ListNode(6)
    listNode.next?.next?.next = ListNode(1)

    sortList(reverseList(listNode))
}

fun reverseList(head: ListNode?): ListNode? {

    if (head == null) return null
    val queue: Stack<Int> = Stack()
    var currentNode = head
    val dammyNode = ListNode(0)

    while (currentNode != null) {
        queue.add(currentNode.`val`)
        currentNode = currentNode.next
    }
    currentNode = dammyNode
    while (queue.size > 0) {
        val value = queue.pop()
        currentNode?.next = ListNode(value)
        currentNode = currentNode?.next
    }
    return dammyNode.next
}

fun reverseList123(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head
    while (curr != null) {
        val nextTemp = curr.next
        curr.next = prev
        prev = curr
        curr = nextTemp
    }
    return prev
}
