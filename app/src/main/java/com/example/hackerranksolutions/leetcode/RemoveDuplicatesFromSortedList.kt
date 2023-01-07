package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {
    val listNode = ListNode(1)
    listNode.next = ListNode(2)
    listNode.next?.next = ListNode(2)
    listNode.next?.next?.next = ListNode(1)

    deleteDuplicates(listNode)
}

fun deleteDuplicates1(head: ListNode?): ListNode? {

    if (head == null) return head

    var currentHead = head
    val deletedDuplicateList: LinkedList<Int> = LinkedList()

    while (currentHead != null) {
        if (!deletedDuplicateList.contains(currentHead.`val`)) {
            deletedDuplicateList.add(currentHead.`val`)
        }
        currentHead = currentHead.next
    }
// Elimde bir liste var ve unique ama onu NodeListe nasıl eklemem gerekiyor onu incelemem gerekiyor

    return currentHead
    }

fun deleteDuplicates(head: ListNode?): ListNode? {
    var current = head
    while (current?.next != null) {
        if (current.next!!.`val` == current.`val`) {
            current.next = current.next!!.next
        } else {
            current = current.next
        }
    }
    return head
}
