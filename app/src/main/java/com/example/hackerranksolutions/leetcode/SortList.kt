package com.example.hackerranksolutions.leetcode

import kotlin.collections.ArrayList

fun main() {

    val listNode = ListNode(2)
    listNode.next = ListNode(3)
    listNode.next?.next = ListNode(6)
    listNode.next?.next?.next = ListNode(1)

    sortList(listNode)
}

fun sortList(head: ListNode?): ListNode? { // if all element just usage one time

    if (head == null) return null
    val hashSet: MutableList<Int> = ArrayList()
    var currentHead = head
    val dammy = ListNode(0)
    var curr: ListNode? = dammy

    while (currentHead != null) {
        hashSet.add(currentHead.`val`)
        currentHead = currentHead.next
    } // O(n)

    val sorted = hashSet.sorted() // O(n)

    sorted.map {
        curr!!.next = ListNode(it)
        curr = curr?.next

    } // O(n)

    return dammy.next
}  // O(3n)
