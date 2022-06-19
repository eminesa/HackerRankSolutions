package com.example.hackerranksolutions.solutions

fun main(){

    println(timeConversion("09:30:00PM"))

}

// joinToString() ile listeyi bir stringe çeviriyor. içine aldığı seperator ile elemanlarının aralarına : koyar
// "%02d".format(it) ile eger gelen time icinde tek bir rakam varsa basına sıfır koymayı saglar.

fun formatTime(data: List<Int>) = data.joinToString(":"){"%02d".format(it)}

fun timeConversion(values: String): String {

    //int tipinde bir liste oluştur diyorum
    // removeSuffix() gelen string içinde eğer silinmesini istediğimiz bir stringi silmek için kullanılır.
    // split() metodu ile istenen stringden bölerek bir liste oluşturur.
    //time:  gelen saatleri baştan sona doğru içinde tutan bir liste oldu artık
    val time :List<Int> = values.removeSuffix("PM").removeSuffix("AM").split(":").map { it.toInt() }

    // Burada da gelen string de AM yada PM olma durumuna göre ayıracağım
    // Eger ogleden sonra ise (PM demek) eger gelen sayı 12'den kucukse 12 eklemen lazim ki askeri saate uygun olarak yazdiralim saaati
    // Sadece saat uzerinde degişim yapacagiz.
    return when {
        values.endsWith("PM") -> {
            val hour = if(time[0] < 12) time[0] + 12 else time[0]
            formatTime(listOf(hour, time[1],time[2]))

        }
        // Eger ogleden sonra ise saatin 12ye esit olma durumunu kontrol edicez
        // esit ise saatten 12 yi cıkaracagız veeeeee sonucu dondurecegiz yes bu kadar
        values.endsWith("AM") -> {

            val hour = if(time[0] == 12) time[0] - 12 else time[0]
            formatTime(listOf(hour, time[1],time[2]))
        }
        else -> {
            "Time Error"
        }
    }

}