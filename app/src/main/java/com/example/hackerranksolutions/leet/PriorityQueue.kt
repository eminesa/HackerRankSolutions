package com.example.hackerranksolutions.leet

import java.util.*

fun main() {
    val stack  = Stack<Int>()

    stack.add(30)
    stack.add(20)
    stack.add(10)
    stack.add(40) // peek dediğimiz zaman  son giren ilk çıkar mantığı ile 40 bize döner


    println(stack.joinToString(" -> "))

    println(stack.peek() ?: "")   // peek() ile ilk elemanı getiriyoruz. Ama silme vs bir işlem yapmadan
    println(stack.joinToString(" -> "))

    println(stack.remove(40)) // 10 silindiği için artık ilk eleman 20 oluyor
    println(stack.peek() ?: "")   // peek ile ilk elemanı getiriyoruz. Ama silme vs bir işlem yapmadan

  /*  val queue: PriorityQueue<Int> = PriorityQueue()

    queue.add(30)
    queue.offer(20)
    queue.add(10)
    queue.offer(40)

    println(queue.joinToString(" -> "))
    // println(queue.poll() ?: "")
    println(queue.remove(10)) // 10 silindiği için artık ilk eleman 20 oluyor
    println(
        queue.poll() ?: ""
    ) // poll ile ilk elemanı çağırıyoruz ve çağırdığımız elemanı siliyoruz silindiği için artık ilk eleman 20 oluyor
    println(
        queue.peek() ?: ""
    )  // peek ile ilk elemanı getiriyoruz. Ama silme vs bir işlem yapmadan
    println(queue.poll() ?: "")
*/

/*    val que: PriorityQueue<Int> = PriorityQueue()

    for (element in 10 downTo 1) {
        que.offer(element) ///---> 10 9 8 7 .... 1 şeklinde verilerin eklenmesini sağladık <---\\\
        print(que.peek() ?:"boş geldi")
     } */

}