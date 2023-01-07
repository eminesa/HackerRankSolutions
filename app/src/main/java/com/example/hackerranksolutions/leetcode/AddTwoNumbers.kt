package com.example.hackerranksolutions.leetcode

fun main() {
    val result = addTwoNumbers(arrayOf(9, 9, 9, 9, 9, 9, 9), arrayOf(9, 9, 9, 9))
    println(result.joinToString("  "))

    val listNode1 = ListNode(9)
    listNode1.next = ListNode(9)
    listNode1.next?.next = ListNode(9)
    listNode1.next?.next?.next = ListNode(9)
    listNode1.next?.next?.next?.next = ListNode(9)
    listNode1.next?.next?.next?.next?.next = ListNode(9)
    listNode1.next?.next?.next?.next?.next?.next = ListNode(9)


    val listNode = ListNode(9)
    listNode.next = ListNode(9)
    listNode.next?.next = ListNode(9)
    listNode.next?.next?.next = ListNode(9)

    addTwoNumbers(listNode1, listNode)

}

fun addTwoNumbers(l1: Array<Int>?, l2: Array<Int>?): Array<Int> {
    var reminder = 0
    val l1Size = l1?.size ?: 0
    val l2Size = l2?.size ?: 0
    val reminderList: MutableList<Int> = ArrayList()

    for (index in 0 until l1Size - 1) {
        var l2Total = 0
        if (index < l2Size) {
            l2Total = l2?.get(index) ?: 0
        }
        val total = (l1?.get(index) ?: 0) + l2Total + reminder
        val value = total % 10
        reminderList.add(value)

        reminder = total / 10
        if (index == l1Size - 2 && reminder != 0)  // son elemanı konrol ediyorum ona göre elimde kalanım varsa ekliyorum
            reminderList.add(reminder)
    }

    return reminderList.toTypedArray()
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var newl1 = l1
    var newl2 = l2
    var reminder = 0
    val dummyHead = ListNode(0)
    var curr: ListNode? = dummyHead

    while (newl1 != null || newl2 != null || reminder != 0) {

        val l1Total = newl1?.`val` ?: 0
        val l2Total = newl2?.`val` ?: 0

        val total = l1Total + l2Total + reminder
        reminder = total / 10
        val value = total % 10
        curr!!.next = ListNode(value)
        curr = curr.next

        if (newl1 != null) newl1 = newl1.next
        if (newl2 != null) newl2 = newl2.next

    }

    return dummyHead.next // en başta tanımlarken eklediğimiz 0 sininsin diye yaptık
}