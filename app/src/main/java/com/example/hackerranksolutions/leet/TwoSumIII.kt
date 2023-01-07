package com.example.hackerranksolutions.leet

import java.util.*
import kotlin.collections.ArrayList


fun main() {
    /**
     * Your TwoSum object will be instantiated and called as such:
     * var obj = TwoSum()
     * obj.add(number)
     * var param_2 = obj.find(value)
     */
    /* val obj = TwoSum()
     obj.add(1)
     obj.add(3)
     obj.add(5)
     println(obj.find(4))
     println(obj.find(7)) */
    //[[],[3],[2],[1] ,[2],[3],[4],[5],[6]]
    val obj = TwoSum()
    obj.add(3)
    obj.add(2)
    obj.add(1)
    println(obj.find(2))
    println(obj.find(3))
    println(obj.find(4))
    println(obj.find(5))
    println(obj.find(6))

}

class TwoSumI() { // Time limited
    val numberList: MutableList<Int> = ArrayList()
    fun add(number: Int) {
        numberList.add(number)
    }

    fun find(value: Int): Boolean {

        if (numberList.isEmpty()) return false

        for (index in numberList.indices) {
            val number = numberList[index]
            val element = value - number
            numberList.removeAt(index)
            if (numberList.contains(element)) {
                numberList.add(index, number)
                return true
            } else {
                numberList.add(index, number)
            }

        }

        return false
    }
}

class TwoSum {
    private val nums: ArrayList<Int> = ArrayList()
    private var isSorted: Boolean = false

    /** Add the number to an internal data structure..  */
    fun add(number: Int) {
        nums.add(number)
        isSorted = false
    }

    /** Find if there exists any pair of numbers which sum is equal to the value.  */
    fun find(value: Int): Boolean {
        if (!isSorted) {
            nums.sort()
            isSorted = true
        }
        var low = 0
        var high: Int = nums.size - 1
        while (low < high) {
            val twoSum = nums[low] + nums[high]
            if (twoSum < value) low += 1 else if (twoSum > value) high -= 1 else return true
        }
        return false
    }
}

