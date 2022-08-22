package com.example.hackerranksolutions.leet

import kotlin.math.absoluteValue

fun main() {
  println(wordsTyping(arrayOf("hello", "world"), 2, 8))
    //println(addChar("Emine",'?', 3))
}

fun addChar1(str: String, ch: Char, position: Int): String? {
    return str.substring(0, position) + ch + str.substring(position)
}

fun addChar(str: String?, ch: Char, position: Int): String? {
    val sb = StringBuilder(str)
    sb.insert(position, ch)
    return sb.toString()
}

/*
Input: sentence = ["hello","world"], rows = 2, cols = 8
Output: 1
Explanation:
hello---
world---
The character '-' signifies an empty space on the screen.
 */

fun wordsTyping(sentence: Array<String>, rows: Int, cols: Int): Int {
    var res = 0
    var row = 0
    var col = 0
    var cur = 0
    var length = 0
    for (str in sentence) {
        length += str.length
    }
    while (row < rows) {
        while (col < cols) {
            if (col + length + sentence.size - 1 < cols) {
                col += length + sentence.size
                res++
                continue
            }
            col += sentence[cur].length
            if (cur == sentence.size - 1 && col <= cols) {
                cur = 0
                res++
            } else if (col <= cols) cur++
            //add space if not the last word in the row
            if (col != cols) col++
        }
        row++
        col = 0
    }
    return res
}

fun wordsTyping1(sentence: Array<String>, rows: Int, cols: Int): Int {
    // I have to create a new sentence with new element like hello___ and word____
    // the question is about sentence.size == rows? if yes I will this solution
    val newSentence: HashMap<String, Int> = hashMapOf()
    var index = 0
    while (newSentence.size <= rows) { // for all rows
        while (index < sentence.size) {
            if (sentence[index].length < cols) {
                if (index < sentence.size - 1) {

                    if (sentence[index].length + sentence[index + 1].length < cols) {
                        if (newSentence[sentence[index].plus("-")
                                .plus(sentence[index + 1])] != null
                        ) {
                            newSentence[sentence[index].plus("-").plus(sentence[index + 1])] =
                                newSentence[sentence[index].plus("-")
                                    .plus(sentence[index + 1])]?.absoluteValue ?: 0 + 1
                        } else {
                            newSentence[sentence[index].plus("-").plus(sentence[index + 1])] = 1
                        }

                    } else {
                        newSentence[sentence[index].plus("_".repeat(cols-sentence[index].length))] = 1
                    }
                }
            }

         /*   if (newSentence.size == rows) {
                index = sentence.size
            } else {
                if (index == sentence.size) {
                    index = 0
                }
            } */
            index++
        }
    }

    //and check the sentence calling the same word how many time
    return 1
}