package com.example.hackerranksolutions.leet

fun main() {
checkDistances("abaccb", intArrayOf(1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
}
fun checkDistances(s: String, distance: IntArray): Boolean {
    val map: MutableMap<Char, Int> = HashMap()
    val arr = s.toCharArray()

    for (i in arr.indices) {
        if (map.containsKey(arr[i])) {
            val start = map[arr[i]]!!
            val diff = i - start - 1
            if (distance[arr[i] - 'a'] != diff) return false
        } else map[arr[i]] = i
    }
    return true
}