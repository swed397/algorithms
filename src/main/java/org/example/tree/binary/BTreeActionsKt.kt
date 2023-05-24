package org.example.tree.binary

interface BTreeActionsKt {

    fun add(value: Int)

    fun containsNode(value: Int): Boolean

    fun deleteNode(value: Int)

    fun traverse()

    fun traverseLevel()
}