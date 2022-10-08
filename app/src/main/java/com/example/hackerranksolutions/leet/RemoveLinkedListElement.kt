package com.example.hackerranksolutions.leet

fun main() {

    val listNode = ListNode(1)
    listNode.next = ListNode(2)
    listNode.next?.next = ListNode(2)
    listNode.next?.next?.next = ListNode(1)

    removeElements(listNode, 2)
}

fun removeElements(head: ListNode?, `val`: Int): ListNode? {

    if (head == null) return head

    var currentHead = head
    val sentinel = ListNode(0)
    sentinel.next = head
    var previous = sentinel

    while (currentHead != null) {
        if (currentHead.`val` == `val`) {
            previous.next = currentHead.next
        } else{
            previous = currentHead
        }

        currentHead = currentHead.next
    }

    return sentinel.next
}