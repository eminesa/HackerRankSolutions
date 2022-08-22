package com.example.hackerranksolutions.leetcode

fun main() {
    println()
}

fun addTwoNumbers(l1: Array<Int>?, l2: Array<Int>?): Array<Int> {
    val newL1 = changeTheLastAndFirstElement(l1)
    val newL2 = changeTheLastAndFirstElement(l2)

    val totalArray: Int = newL2?.joinToString("")?.toInt()
        ?.let { newL1?.joinToString("")?.toInt()?.plus(it) } ?:0

    val totalList = mutableListOf<Int>()
    totalArray.toString().toList().forEach {
       totalList.add(it.toString().toInt())
    }
   return totalList.toTypedArray()
}

fun changeTheLastAndFirstElement(l1: Array<Int>?): Array<Int>? {

    val newL1 = l1?.toMutableList()
    val newL1FirstElement: Int? = l1?.first()
    val lastIndex: Int? = l1?.size?.minus(1)

    if (lastIndex != null && newL1FirstElement != null) {
        if (lastIndex > 0) {
            val newL1LastElement = l1[lastIndex]
            newL1?.removeAt(0)
            newL1?.add(0, newL1LastElement)
            newL1?.removeAt(lastIndex)
            newL1?.add(lastIndex, newL1FirstElement)
        }
    }
    return newL1?.toTypedArray()

}