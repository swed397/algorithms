package org.example.selection.sort

fun main() {
    val listToSort = arrayListOf(1, 5, 7, 3, 7, 3)

    val sortedList = listToSort.selectionSort()
    println(sortedList)
}

fun     ArrayList<Int>.findSmallest(): Int {
    var smallestValue = this[0]
    var smallestIndex = 0

    for (i in this.indices) {
        if (this[i] < smallestValue) {
            smallestValue = this[i]
            smallestIndex = i
        }
    }

    return smallestIndex
}

fun ArrayList<Int>.selectionSort(): List<Int> {
    val newList = mutableListOf<Int>()
    val listSize = this.size

    for (i in 0 until listSize) {
        val smallestIndex: Int = this.findSmallest()
        newList.add(this[smallestIndex])

        this.removeAt(smallestIndex)
    }

    return newList
}
