package org.example.selection.sort

fun main() {
    val listToSort = arrayListOf(1, 5, 7, 3, 7, 3)

    val sortedList = listToSort.selectionSort(listToSort)
    println(sortedList)
}

fun ArrayList<Int>.findSmallest(list: List<Int>): Int {
    var smallestValue = list[0]
    var smallestIndex = 0;

    for (i in list.indices) {
        if (list[i] < smallestValue) {
            smallestValue = list[i]
            smallestIndex = i
        }
    }

    return smallestIndex
}

fun ArrayList<Int>.selectionSort(list: ArrayList<Int>): List<Int> {
    val newList = mutableListOf<Int>()
    val listSize = list.size

    for (i in 0 until listSize) {
        val smallestIndex: Int = this.findSmallest(list)
        newList.add(list[smallestIndex])

        list.removeAt(smallestIndex)
    }

    return newList
}
