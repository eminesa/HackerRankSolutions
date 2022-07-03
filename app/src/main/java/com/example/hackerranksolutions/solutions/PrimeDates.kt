package com.example.hackerranksolutions.solutions

fun main() {
    print(findPrimeDates("02-08-2024"))
}

fun findPrimeDates(date: String): Boolean {

    var totalCount = ""

    val chancedDate =  date.split("-") // bir list yapmak için kullanılır // date.replace("-", "") string içindeki belli bir değeri değiştirmek için kullanılır

    chancedDate.map { element ->

        totalCount = if (element.startsWith("0")){
            totalCount.plus(element.replace("0", ""))
        }else{
            totalCount.plus(element)
        }
    }

    return totalCount.toInt() % 4 == 0 || totalCount.toInt() % 7 == 0
}