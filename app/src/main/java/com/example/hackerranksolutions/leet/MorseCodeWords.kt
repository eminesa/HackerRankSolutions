package com.example.hackerranksolutions.leet

fun main() {
    println(uniqueMorseRepresentations(arrayOf("gin","zen","gig","msg")))
}

fun uniqueMorseRepresentations(words: Array<String>): Int {
    val morse = arrayOf(".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
        "....", "..", ".---", "-.-", ".-..", "--", "-.",
        "---", ".--.", "--.-", ".-.", "...", "-", "..-",
        "...-", ".--", "-..-", "-.--", "--..")

    val seen: MutableSet<String> = HashSet() // key ile kaydedip uniq olani bulmak istiyoruz.
    for (word in words) {  //verilen tum liste uzerinde dolasiyoruz
        val code = StringBuilder() //bir degişken oluşturuyoruz
        for (charOfWord in word.toCharArray()) { //ve morse diline çevireceğimiz değeri içine atiyoruz.
            code.append(morse[charOfWord - 'a'])
        }
        seen.add(code.toString())
    }
    return seen.size
}
