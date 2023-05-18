package org.example.dynam

import java.util.*
import kotlin.math.max

fun main() {

    val longestWordPart = LongestWordPartKt("hish", "fish")
    val matrix = longestWordPart.process()

    println("Matrix longest path : " + matrix.contentDeepToString())
    println("Max longest part value : " + Arrays.stream(matrix)
        .flatMapToInt { array: IntArray? -> Arrays.stream(array) }
        .max()
        .asInt
    )
}

class LongestWordPartKt(
    private val wordA: String,
    private val wordB: String
) {

    private var matrix: Array<IntArray> = Array(wordA.length) { IntArray(wordB.length) }

    fun process(): Array<IntArray> {
        for (i in wordA.indices) {
            for (j in wordB.indices) {
                if (wordA[i] == wordB[j]) {
                    if (i > 0 && j > 0) {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1
                    } else {
                        matrix[i][j] = 1
                    }
                } else {
                    if (i == 0 && j > 0) {
                        matrix[i][j] = matrix[i][j - 1]
                    } else if (i > 0 && j == 0) {
                        matrix[i][j] = matrix[i - 1][j]
                    } else if (i > 0 && j > 0) {
                        matrix[i][j] = max(matrix[i - 1][j], matrix[i][j - 1])
                    }
                }
            }
        }
        return matrix
    }
}