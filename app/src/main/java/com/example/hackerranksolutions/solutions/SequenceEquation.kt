package com.example.hackerranksolutions.solutions

fun main() {
    val result =   permutationEquation(arrayOf(5,2,1,3,4))

    println(result.joinToString(" "))

}

fun permutationEquation(p: Array<Int>): Array<Int> {

    val listOfFirst =  mutableListOf<Int>() // sıralı bir liste oluşturuyorzu

     p.sorted().map {  element ->
         // sıralı listedeki elemanların hangi indexte bulunduğunu bulmaya calısıyoruz.
         p.mapIndexed { index, i ->
             if (element == i){
                 listOfFirst.add(index+1)
             }
         }
    }

    val mutableList = mutableListOf<Int>()

    listOfFirst.map { element ->
      //bu kisimda siralama önemli oldugu icin tek tek bulmaya calısalım
        p.mapIndexed { index, i ->
            if (element == i){
                mutableList.add(index+1)
            }
        }

    }


    return mutableList.toTypedArray()
}
