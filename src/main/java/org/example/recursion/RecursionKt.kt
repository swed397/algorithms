package org.example.recursion

import java.util.stream.Stream

fun main() {
    countDown(5)

    println("List sum: " + listSum(mutableListOf(1, 2, 3)))
    println("List elem count: " + listElemCounter(mutableListOf(1, 2, 3)))
    println("List max value: " + maxElem(mutableListOf(1, 2, 3, 9, 4, 3, 6, 10)))
    println("Qsort: " + qsort(listOf(1, 2, 3, 9, 4, 3, 6, 10)))
}

fun countDown(value: Int) {
    if (value != 0) {
        println(value)
        countDown(value - 1)
    }
}

fun listSum(list: MutableList<Int>): Int = when (list.size) {
    0 -> 0
    else -> {
        val value = list[0]
        list.removeAt(0)
        value + listSum(list)
    }
}

fun listElemCounter(list: MutableList<Int>): Int = when (list.size) {
    0 -> 0
    else -> {
        list.removeAt(0)
        1 + listElemCounter(list)
    }
}


fun maxElem(list: MutableList<Int>): Int =
    when (list.size) {
        2 -> if (list[0] > list[1]) list[0] else list[1]
        else -> {
            list.removeAt(0)
            val max = maxElem(list)
            if (list[0] > max) list[0] else max
        }
    }

fun qsort(list: List<Int>): List<Int> {
    return if (list.size < 2) {
        list;
    } else {
        val pivot = list[list.size / 2]
        val equal = list.filter { it == pivot }
        val less = list.filter { it < pivot }
        val greater = list.filter { it > pivot }
        println(less)
        println(greater)
        return qsort(less) + equal + qsort(greater)
    }
}

