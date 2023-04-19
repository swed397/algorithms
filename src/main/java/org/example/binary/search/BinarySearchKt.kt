package org.example.binary.search

import kotlin.random.Random

fun main() {
    val limit = 10

    val intList = List(limit) { Random.nextInt(0, 100) }.sorted()

    val randomInt = Random.nextInt(0, limit)
    val randomIntFromList = intList[randomInt]
    val pos = BinarySearchKt(intList).getPosition(randomIntFromList)

    println("List: $intList")
    println("Random int from list: $randomIntFromList")
    println("Pos $pos")

}

class BinarySearchKt(private var list: List<Int>) {

    fun getPosition(item: Int): Int {
        var low = 0
        var high = list.size - 1

        while (low <= high) {
            val mid = (low + high) / 2
            val guess = list[mid]

            if (guess == mid) {
                return mid
            }

            if (guess > item) {
                high = mid - 1
            } else if (guess < item) {
                low = mid + 1
            }
        }

        return -1
    }

}