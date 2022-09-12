package com.example.hackerranksolutions.leet

fun main() {//4,1,8,4,5
    val listNode = ListNode(4)
    listNode.next = ListNode(1)
    listNode.next?.next = ListNode(8)
    listNode.next?.next?.next = ListNode(4)
    listNode.next?.next?.next?.next = ListNode(5)

    ///5,6,1,8,4,5
    val listNode1 = ListNode(5)
    listNode1.next = ListNode(6)
    listNode1.next?.next = ListNode(1)
    listNode.next?.next?.next = ListNode(8)
    listNode.next?.next?.next?.next = ListNode(4)
    listNode.next?.next?.next?.next?.next = ListNode(5)

    println(getIntersectionNode(listNode1, listNode))
}

fun getIntersectionNode1(headA: ListNode?, headB: ListNode?): ListNode? {
    if (headA == null || headB == null) return null
    // I will use queue (FIFO)
    val headAList: MutableList<Int> = ArrayList()
    val headBList: MutableList<Int> = ArrayList()

    var currentA = headA
    var currentB = headB

    while (currentA != null) {
        headAList.add(currentA.`val`) // I have all path
        currentA = currentA.next
    }

    while (currentB != null) {
        headBList.add(currentB.`val`)
        //if (headAList.contains(currentB.`val`)) return ListNode(currentB.`val`)
        currentB = currentB.next
    }

    return null
}

fun getIntersectionNode12(headA: ListNode?, headB: ListNode?): ListNode? {
    var currentHeadA = headA
    while (currentHeadA != null) {
        var pB = headB
        while (pB != null) {
            if (currentHeadA == pB) return currentHeadA
            pB = pB.next
        }
        currentHeadA = currentHeadA.next
    }
    return null
}


fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var pA = headA
    var pB = headB
    while (pA != pB) {
        pA = if (pA == null) headB else pA.next
        pB = if (pB == null) headA else pB.next
    }
    return pA
    // Note: In the case lists do not intersect, the pointers for A and B
    // will still line up in the 2nd iteration, just that here won't be
    // a common node down the list and both will reach their respective ends
    // at the same time. So pA will be NULL in that case.
}