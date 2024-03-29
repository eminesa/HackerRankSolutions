package com.example.hackerranksolutions.leetcode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val listNode = ListNode(1)
    listNode.next = ListNode(2)
    listNode.next?.next = ListNode(2)
    listNode.next?.next?.next = ListNode(1)

    isPalindrome(listNode)

}

fun isPalindrome(head: ListNode?): Boolean {
    val listOfNumber: MutableList<Int> = ArrayList()

    var currentNode = head
    while (currentNode != null) {
        listOfNumber.add(currentNode.`val`)
        currentNode = currentNode.next
    }

    // Use two-pointer technique to check for palindrome.
    var front = 0
    var back = listOfNumber.size - 1
    while (front < back) {
        // Note that we must use ! .equals instead of !=
        // because we are comparing Integer, not int.
        if (listOfNumber[front] != listOfNumber[back]) {
            return false
        }
        front++
        back--
    }
    return true
}

fun isPalindrome1(head: ListNode?): Boolean {
    val listOfNumber: MutableList<Int> = ArrayList()

    var currentNode = head
    while (currentNode != null) {
        listOfNumber.add(currentNode.`val`)
        currentNode = currentNode.next
    }

    if (listOfNumber.size <= 1) {
        return true
    }
    var isPalindromes = true
    for (index in 0 until listOfNumber.size / 2) {
        if (listOfNumber[index] != listOfNumber[listOfNumber.size - 1 - index]) {
            isPalindromes = false
        }
    }

    return isPalindromes
}