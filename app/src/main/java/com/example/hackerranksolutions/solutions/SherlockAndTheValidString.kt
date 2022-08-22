package com.example.hackerranksolutions.solutions

fun main() {
    println(isValid("abc"))
    println(isValid("abcc"))
    println(isValid("abccc"))
    println(isValid("aabbcd"))
    println(isValid("abcdefghhgfedecba"))
}

/* 16/20 true test case*/
fun isValid(s: String): String {

        var isValidString = true
        val charHashMap = HashMap<Char, Int>()

        s.map { charElement ->
            if (charHashMap.containsKey(charElement)) {
                charHashMap[charElement] = charHashMap.getValue(charElement) + 1
            } else {
                charHashMap.put(charElement, 1)
            }
        }

        val list = mutableListOf<Int>()

        charHashMap.mapValues {
            list.add(it.value)
        }

        for (index in 0 until list.size) {
            if (index < list.size - 1) {
                if (list[index] != list[index + 1]) {
                    if (list[index] == list[index + 1] - 1) {
                        list[index + 1] = list[index]
                    } else {
                        isValidString = false
                        break
                    }
                }
            }
        }

        return if (isValidString) "YES" else "NO"
    }
