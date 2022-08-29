package com.example.hackerranksolutions.solutions

fun main() {
    // val result = icecreamParlor(4, arrayOf(1, 4, 5, 3, 2))
    val result = icecreamParlor(5, arrayOf(2, 2, 4, 1))
    println(result.joinToString(" "))
}

fun icecreamParlor1(m: Int, arr: Array<Int>): Array<Int> {

    val list : MutableList<Int> = ArrayList()

    for (firstPrice in arr.indices) {

        for (secondPrice in arr.indices) {
            if (firstPrice == secondPrice) {
                continue
            }
            if (arr[firstPrice] + arr[secondPrice] == m) {
                list.clear()
                list.add(secondPrice + 1)
                list.add(firstPrice + 1)
                break
            }
        }
    }

    return list.toTypedArray()
}

// Time complexity O(n)
// space complexity O(n)
fun icecreamParlor(m: Int, arr: Array<Int>): Array<Int> {

    val indexList: MutableList<Int> = ArrayList()
    val map: HashMap<Int, Int> = HashMap()

    for (i in arr.indices) {
        val key = m - arr[i]
        if (map.containsKey(key)) {
            indexList.add(i + 1)
            indexList.add(map[key]?.plus(1) ?: 0)
            break
        } else {
            map[arr[i]] = i
        }
    }
    return indexList.sorted().toTypedArray()
}