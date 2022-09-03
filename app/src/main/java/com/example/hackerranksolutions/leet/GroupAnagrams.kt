package com.example.hackerranksolutions.leet

import java.util.*

fun main() {

    val result = groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    println(result.joinToString("\n"))

}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    if (strs.isEmpty()) return ArrayList()

    val groupMutableMap: MutableMap<String, MutableList<String>> = HashMap()
    for (s in strs) {
        val wordToCharArray = s.toCharArray()
        Arrays.sort(wordToCharArray)
        val key = String(wordToCharArray)
        if (!groupMutableMap.containsKey(key)) groupMutableMap[key] = ArrayList()
        groupMutableMap[key]!!.add(s)
    }
    return ArrayList(groupMutableMap.values)
}