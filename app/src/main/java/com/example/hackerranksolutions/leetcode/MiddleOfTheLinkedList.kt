package com.example.hackerranksolutions.leetcode

fun main() {
    val listNode = ListNode(1)
    listNode.next = ListNode(2)
    listNode.next?.next = ListNode(2)
    listNode.next?.next?.next = ListNode(1)
    println(middleNode(listNode))
}

fun middleNode1(head: ListNode?): ListNode? {
    val allArray: MutableList<Int> = ArrayList()
    val middleNode = ListNode(0)
    var currentHead = head

    while (currentHead != null) {
        allArray.add(currentHead.`val`)
        currentHead = currentHead.next
    }
    currentHead = middleNode
    val size = allArray.size / 2
    for (index in size until allArray.size) {
        currentHead?.next = ListNode(allArray[index])
        currentHead = currentHead?.next
    }

    return middleNode.next
}

fun middleNode(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow!!.next
        fast = fast.next!!.next
    }
    return slow
}
