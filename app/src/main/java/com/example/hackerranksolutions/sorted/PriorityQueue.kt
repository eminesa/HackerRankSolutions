package com.example.hackerranksolutions.sorted

import java.util.*

fun main()
{
    //Highest Priority Queue
    val employeesIds: PriorityQueue<Int> = PriorityQueue()
    // Add 33, 65, 78 , 2 to the employeesIds
    employeesIds.offer(33)
    employeesIds.offer(65)
    employeesIds.offer(78)
    employeesIds.offer(2)

    while(!employeesIds.isEmpty()) {
      val outOfList =   employeesIds.poll() // output: 78, 65, 33, 2
        outOfList?.let { println(it) }
    }

}