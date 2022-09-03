package com.example.hackerranksolutions.leet

fun main() {

    //  list1 = [1,2,4], list2 = [1,3,4]
    val list1 = ListNode(1)
    list1.next = ListNode(2)
    list1.next?.next = ListNode(4)
    val list2 = ListNode(1)
    list2.next = ListNode(3)
    list2.next?.next = ListNode(4)

    mergeTwoLists(list1, list2)

}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var currentList1 = list1
    var currentList2 = list2
    val mergedList = ListNode(0)
    var prev: ListNode? = mergedList

    while (currentList1 != null || currentList2 != null) {
        if (currentList1?.`val` != null && currentList2?.`val` != null) {
            if (currentList1.`val` <= currentList2.`val`) {
                prev?.next = ListNode(currentList1.`val`)
                currentList1 = currentList1.next
            } else {
                prev?.next = ListNode(currentList2.`val`)
                currentList2 = currentList2.next
            }
        } else if (currentList1 != null) {
            prev?.next = ListNode(currentList1.`val`)
            currentList1 = currentList1.next
        } else if (currentList2 != null) {
            prev?.next = ListNode(currentList2.`val`)
            currentList2 = currentList2.next
        }
        prev = prev?.next
    }

    return mergedList.next
}


fun mergeTwoLists1(l1: ListNode?, l2: ListNode?): ListNode? {

    var currentList1 = l1
    var currentList2 = l2
    val prehead = ListNode(-1)
    var prev: ListNode? = prehead

    while (currentList1 != null && currentList2 != null) {
        if (currentList1.`val` <= currentList2.`val`) {
            prev?.next = currentList1
            currentList1 = currentList1.next
        } else {
            prev?.next = currentList2
            currentList2 = currentList2.next
        }
        prev = prev?.next
    }

    // At least one of l1 and l2 can still have nodes at this point, so connect
    // the non-null list to the end of the merged list.
    prev?.next = currentList1 ?: currentList2
    return prehead.next
}