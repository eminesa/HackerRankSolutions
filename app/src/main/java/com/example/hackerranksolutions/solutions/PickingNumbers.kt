package com.example.hackerranksolutions.solutions

fun main() {
    println(pickingNumbers(arrayOf(4, 6, 5, 3, 3, 1)))
    println(pickingNumbers1(arrayOf(4, 6, 5, 3, 3, 1)))
}

fun pickingNumbers(a: Array<Int>): Int {
    val frequency = IntArray(101) // int tipinde bir dizi olusturuyoruz. dizinin 100 tane değeri var ve içine 0 alıyor her eleman için

    var result = Int.MIN_VALUE

    for (i in a.indices) {
        val index = a[i]
        frequency[index]++
    }

    for (i in 1..100) { /*list index min 0 olabildiği için 1 den başlattık*/
        result = result.coerceAtLeast(frequency[i] + frequency[i - 1])
    }

    return result
}

fun pickingNumbers1(a: Array<Int>): Int {

    val frequency = IntArray(101) /* int tipinde bir dizi olusturuyoruz. dizinin 100 tane değeri var ve içine 0 alıyor her eleman için */

    var result = Int.MIN_VALUE /*Min değerin int icin int'ten min değer olarak belirlediği değeri alacak*/

    a.map {element ->
        frequency[element]++
    }

    (1..100).map { index ->
        result = result.coerceAtLeast(frequency[index] + frequency[index - 1])
    }

    return result
}

