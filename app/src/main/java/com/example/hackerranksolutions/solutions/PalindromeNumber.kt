package com.example.hackerranksolutions.solutions

fun main() {
    println(isPalindrome(-12213))
}

fun isPalindrome(x: Int): Boolean {
    var isPalindrome = true
    val listOfX = x.toString().toCharArray()

    when {
        x < 0 -> {
            isPalindrome = false
        }
        x.toString().length == 1 -> {
            isPalindrome = true
        }
        x.toString().length > 1 -> {
            var right = listOfX.size - 1
            for (index in 0..listOfX.size / 2) {
                if (listOfX[index] != listOfX[right]) {
                    isPalindrome = false
                    break
                } else {
                    right--
                }
            }

        }
    }
    return isPalindrome
}

