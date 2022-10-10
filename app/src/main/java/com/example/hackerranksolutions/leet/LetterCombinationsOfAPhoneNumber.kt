package com.example.hackerranksolutions.leet

fun main() {
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    val result1 = letterCombinations("23")
    println(result1.joinToString(" "))
    val result = letterCombinations("2345")
    //val result = letterCombinations("9")
    println(result.joinToString(" "))
}

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return listOf()

    val numberAndLetterHashMap: HashMap<Char, CharArray> = HashMap()
    numberAndLetterHashMap['2'] = charArrayOf('a', 'b', 'c')
    numberAndLetterHashMap['3'] = charArrayOf('d', 'e', 'f')
    numberAndLetterHashMap['4'] = charArrayOf('g', 'h', 'i')
    numberAndLetterHashMap['5'] = charArrayOf('j', 'k', 'l')
    numberAndLetterHashMap['6'] = charArrayOf('m', 'n', 'o')
    numberAndLetterHashMap['7'] = charArrayOf('p', 'q', 'r', 's')
    numberAndLetterHashMap['8'] = charArrayOf('t', 'u', 'v')
    numberAndLetterHashMap['9'] = charArrayOf('w', 'x', 'y', 'z')

    val letterCombinationList: MutableList<String> = ArrayList()
    var currentString = digits
    if (letterCombinationList.isEmpty()) {
        for (letter in numberAndLetterHashMap[currentString.first()]!!) {
            letterCombinationList.add(letter.toString())
        }
        currentString = currentString.removeRange(0, 1)

    }  

    val currentList: MutableList<String> = ArrayList()
    while (currentString.isNotEmpty()) {
        currentList.clear()
        for (letter in numberAndLetterHashMap[currentString.first()]!!) {
            for (i in letterCombinationList.indices) {
                val value = letterCombinationList[i] + letter
                currentList.add(value)
            }
        }

        letterCombinationList.clear()
        for (element in currentList) {
            letterCombinationList.add(element)
        }
        currentString = currentString.removeRange(0, 1)
    }

    return letterCombinationList
}

internal class LetterCombinationsOfAPhoneNumber {

    private val combinations: MutableList<String> = ArrayList()
    private var phoneDigits: String? = null

    fun letterCombinations(digits: String): List<String> {
        // If the input is empty, immediately return an empty answer array
        if (digits.isEmpty()) {
            return combinations
        }

        // Initiate backtracking with an empty path and starting index of 0
        phoneDigits = digits
        backtrack(0, StringBuilder())
        return combinations
    }

    private fun backtrack(index: Int, path: StringBuilder) {
        val letters: HashMap<Char, CharArray> = HashMap()
        letters['2'] = charArrayOf('a', 'b', 'c')
        letters['3'] = charArrayOf('d', 'e', 'f')
        letters['4'] = charArrayOf('g', 'h', 'i')
        letters['5'] = charArrayOf('j', 'k', 'l')
        letters['6'] = charArrayOf('m', 'n', 'o')
        letters['7'] = charArrayOf('p', 'q', 'r', 's')
        letters['8'] = charArrayOf('t', 'u', 'v')
        letters['9'] = charArrayOf('w', 'x', 'y', 'z')

        // If the path is the same length as digits, we have a complete combination
        if (path.length == phoneDigits!!.length) {
            combinations.add(path.toString())
            return  // Backtrack
        }

        // Get the letters that the current digit maps to, and loop through them
        val possibleLetters = letters[phoneDigits!![index]]
        for (letter in possibleLetters!!) {
            // Add the letter to our current path
            path.append(letter)
            // Move on to the next digit
            backtrack(index + 1, path)
            // Backtrack by removing the letter before moving onto the next
            path.deleteCharAt(path.length - 1)
        }
    }
}