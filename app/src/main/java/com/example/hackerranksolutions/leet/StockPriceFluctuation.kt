package com.example.hackerranksolutions.leet

import java.util.*

class StockPriceM {

    private val stockHashmap: HashMap<Int, Int> = LinkedHashMap()
    var lastValue = 0
    fun update(timestamp: Int, price: Int) {
        stockHashmap[timestamp] = price

        lastValue =Math.max(timestamp, lastValue)
    }

    fun current(): Int {
       return stockHashmap[lastValue] ?:0
    }

    fun maximum(): Int {
        var maxValue = Int.MIN_VALUE
        for (element in stockHashmap){
             maxValue = Math.max(maxValue, element.value)
        }
        return maxValue
    }

    fun minimum(): Int {
        var minValue = Int.MAX_VALUE
        for (element in stockHashmap ){
            minValue = Math.min(minValue, element.value)
        }
        return minValue
    }

}


fun main() {
    val stockPrice = StockPrice()
    stockPrice.update(1, 10) // Timestamps are [1] with corresponding prices [10].

    stockPrice.update(2, 5) // Timestamps are [1,2] with corresponding prices [10,5].

    stockPrice.current() // return 5, the latest timestamp is 2 with the price being 5.

    stockPrice.maximum() // return 10, the maximum price is 10 at timestamp 1.

    stockPrice.update(1, 3) // The previous timestamp 1 had the wrong price, so it is updated to 3.

    // Timestamps are [1,2] with corresponding prices [3,5].
    // Timestamps are [1,2] with corresponding prices [3,5].
    stockPrice.maximum() // return 5, the maximum price is 5 after the correction.

    stockPrice.update(4, 2) // Timestamps are [1,2,4] with corresponding prices [3,5,2].

    stockPrice.minimum() // return 2, the minimum price is 2 at timestamp 4.

}

class StockPrice {
    var latestTime = 0

    // Store price of each stock at each timestamp.
    var timestampPriceMap: MutableMap<Int, Int> = HashMap()

    // Store stock prices in increasing order to get min and max price.
    var priceFrequency: TreeMap<Int, Int> = TreeMap()
    fun update(timestamp: Int, price: Int) {
        // Update latestTime to latest timestamp.
        latestTime = Math.max(latestTime, timestamp)

        // If same timestamp occurs again, previous price was wrong.
        if (timestampPriceMap.containsKey(timestamp)) {
            // Remove previous price.
            val oldPrice = timestampPriceMap[timestamp]!!
            priceFrequency[oldPrice] = priceFrequency[oldPrice]!! - 1

            // Remove the "entry from the map.
            if (priceFrequency[oldPrice] === 0) {
                priceFrequency.remove(oldPrice)
            }
        }

        // Add latest price for timestamp.
        timestampPriceMap[timestamp] = price
        priceFrequency[price] = priceFrequency.getOrDefault(price, 0) + 1
    }

    fun current(): Int {
        // Return latest price of the stock.
        return timestampPriceMap[latestTime]!!
    }

    fun maximum(): Int {
        // Return the maximum price stored at the end of sorted-map.
        return priceFrequency.lastKey()
    }

    fun minimum(): Int {
        // Return the maximum price stored at the front of sorted-map.
        return priceFrequency.firstKey()
    }

}

class DescendingOrderStringComparator : Comparator<String>
{
    override fun compare(string1: String, string2: String): Int
    {
        // By comparing string2 to string1, we make it descending comparator.
        return string2.compareTo(string1)
    }
}
