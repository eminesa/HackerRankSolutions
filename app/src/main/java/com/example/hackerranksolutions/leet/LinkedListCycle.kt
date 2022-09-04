package com.example.hackerranksolutions.leet

fun main() {

    val listNode = ListNode(1)
    // listNode.next = ListNode(2)
    //listNode.next?.next = ListNode(0)
    //listNode.next?.next?.next = ListNode(-4)
    val sol = Sol()
    println(hasCycle(listNode))
    println(sol.hasCycle(listNode))
}

class Sol {
    var currentHead: ListNode? = null
    var nodeCounter = 0
    fun hasCycle(head: ListNode?): Boolean {
        currentHead = head

        if (head?.`val` != null) {
            nodeCounter += 1
            return if (head.next != null) {
                hasCycle(head.next)
            } else {
                isContain(currentHead, nodeCounter)
            }
        }
        return false
    }

    private fun isContain(head: ListNode?, searchNode: Int): Boolean {

        if (head?.`val` != null) {
            if (head.`val` == searchNode) return true
            return if (head.next != null) {
                isContain(head.next, searchNode)
            } else {
                false
            }
        }

        return false
    }
}

fun hasCycle(head: ListNode?): Boolean {
    if (head == null) {
        return false
    }
    var slow = head
    var fast = head.next
    while (slow != fast) {
        if (fast?.next == null) {
            return false
        }
        slow = slow?.next
        fast = fast.next?.next
    }
    return true
}