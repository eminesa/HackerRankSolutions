package com.example.hackerranksolutions.solutions


fun main() {
println(timeInWords(5,47))
}

fun timeInWords(h: Int, m: Int): String {
   var time = ""
    val stringOfTime = arrayOf(
        "zero",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
        "eleven",
        "twelve",
        "thirteen",
        "fourteen",
        "fifteen",
        "sixteen",
        "seventeen",
        "eighteen",
        "nineteen",
        "twenty",
        "twenty one",
        "twenty two",
        "twenty three",
        "twenty four",
        "twenty five",
        "twenty six",
        "twenty seven",
        "twenty eight",
        "twenty nine"
    )

    if(m<=30){
        time = when (m) {
            0 -> stringOfTime[h]+" o' clock"
            15 -> "quarter past "+stringOfTime[h]
            30 -> "half past "+stringOfTime[h]
            1 -> stringOfTime[m]+" minute past "+stringOfTime[h]
            else -> stringOfTime[m]+" minutes past "+stringOfTime[h]
        }
    }
    else{
        time = when (m) {
            45 -> "quarter to "+stringOfTime[h+1]
            59 -> stringOfTime[60-m]+" minute to "+stringOfTime[h+1]
            else -> stringOfTime[60-m]+" minutes to "+stringOfTime[h+1]
        }
    }

    return time
}