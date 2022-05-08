package com.example.hackerrankexamples

fun main() {

    println(hurdleRace(4, arrayOf(1, 6, 3, 5, 2)))

    println(
        hurdleRace(
            53,
            arrayOf(
                86,
                4,
                83,
                20,
                6,
                81,
                58,
                59,
                53,
                2,
                54,
                62,
                25,
                35,
                79,
                64,
                27,
                49,
                32,
                95,
                100,
                20,
                58,
                39,
                92,
                30,
                67,
                89,
                58,
                81,
                100,
                66,
                73,
                29,
                75,
                81,
                70,
                55,
                18,
                28,
                7,
                35,
                98,
                52,
                30,
                11,
                69,
                48,
                84,
                54,
                13,
                14,
                15,
                86,
                34,
                82,
                92,
                26,
                8,
                53,
                62,
                57,
                50,
                31,
                61,
                85,
                88,
                5,
                80,
                64,
                90,
                52,
                47,
                43,
                40,
                93,
                69,
                70,
                16,
                43,
                7,
                25,
                99,
                12,
                63,
                99,
                71,
                76,
                55,
                17,
                90,
                43,
                27,
                20,
                42,
                84,
                39,
                96,
                75,
                1
            )
        )
    )
}

fun hurdleRace(k: Int, height: Array<Int>): Int {

    var jump = 0

    height.map { heightOfIndex->

        if ( heightOfIndex > jump) {
            jump = heightOfIndex
        }

    }

    when {
        k >= jump -> {
            jump = 0
        }
        else -> {
            jump -= k
        }
    }

    return jump
}

fun hurdleRace1(k: Int, height: Array<Int>): Int {

    val sortList = height.sorted()
    var jump = sortList.last()
    when {
        k >= jump -> {
            jump = 0
        }
        else -> {
            jump -= k
        }
    }

    return jump
}
