package com.example.hackerranksolutions.leet

fun main() {
  //  println(climbStairs(3))
    //println(climbStairs(4))
    println(climbStairs(5))
}

fun climbStairs(n: Int): Int {
    // lets think about stair if I have 4 step
    // 1 by one
    // 1 2 1
    // 2 1 1
    // 1 1 2
    // 2 2  // distinct == n
    val sqrt5 = Math.sqrt(5.0) // kök içine alıyoruz verilen degeri
    val phi = (1 + sqrt5) / 2 // bir ile toplayıp  2 ye bölüyoruz
    val psi = (1 - sqrt5) / 2 // birden karenin sonucunu çıkartıyoruz ve 2 ye bölüyoruz.
    return ((Math.pow(phi, (n + 1).toDouble()) - Math.pow(psi, (n + 1).toDouble())) / sqrt5).toInt() //
  // bulduğumuz sonuçlarıın (n+1) üslerini alıyoruz. cıkan sonucu kökünü aldığımız değere gölüyoruz Int tipinde olmasına dikkat ediyoruz.
}