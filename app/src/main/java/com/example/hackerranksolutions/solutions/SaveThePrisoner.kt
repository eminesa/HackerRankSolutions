package com.example.hackerranksolutions.solutions

fun main() {
//println(saveThePrisoner(7,19,2))
//print(saveThePrisoner(3,7 ,3))
println(saveThePrisoner(1000000000, 1, 213261504))
}

fun saveThePrisoner1(n: Int, m: Int, s: Int): Int {
    /* n = mahkum sayısı, m = şeker sayıs s= şekerin dağıtılmaya başlanacak sandalye numarası */
    var lastNumberOfPrisoner = s

    for (index in 1 until m){

        if (lastNumberOfPrisoner == n){
            lastNumberOfPrisoner = 1
        } else{
            lastNumberOfPrisoner += 1
        }

    }

    return lastNumberOfPrisoner
} // sadece iki tane test casei doğruluyor

fun saveThePrisoner(n: Int, m: Int, s: Int): Int {

    return 1 + (s - 1 + m - 1) % n
}
