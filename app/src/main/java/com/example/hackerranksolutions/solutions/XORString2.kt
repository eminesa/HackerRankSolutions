package com.example.hackerranksolutions.solutions

fun main() {
    println(stringsXor("10101","00101"))
}

fun stringsXor(s: String, t: String) :String {
    var res = ""


    for (i in s.indices) {
        res = if (t[i] == s[i]) {
            res+"0"
        } else{
            res+"1"
        }
    }

    return res
}