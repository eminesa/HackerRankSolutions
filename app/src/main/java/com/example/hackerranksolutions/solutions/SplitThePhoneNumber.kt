package com.example.hackerranksolutions.solutions

fun main() {

    val result = splitThePhoneNumber(listOf("1 877 2638277", "91-011-23413627")) //todo caseleri test etmek için ekleme yapmak gerekiyor.
    val secondCase = splitThePhoneNumber(listOf("148-809-2561957985", "148-809-2561957985", "188-547-5864327428", "891-454-9195497623", "648-42-380306686", "824-417-6460145493", "489-16-9839392781"))

    println(result.joinToString("\n"))

}

fun splitThePhoneNumber(arr: List<String>): MutableList<String> {
    val splitMutableList = mutableListOf<String>()

    val list = arr.map { it.split("-", " ") } // iki duruma göre ayırıp elemanlardan bir liste oluşturuyor.

    list.map {
        //Elde ettiğimiz liste içinde liste elde edip onlar üzerinde oynama yaparak istediğimiz kurala uyguluyoruz
        splitMutableList.add("CountryCode=".plus(it[0]).plus(",LocalAreaCode=").plus(it[1]).plus(",Number=").plus(it[2]))
    }
    return splitMutableList
}