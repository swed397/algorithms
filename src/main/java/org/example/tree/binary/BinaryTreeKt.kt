package org.example.tree.binary

import java.util.*

class BinaryTreeKt : BTreeActionsKt {

    private var root: NodeKt? = null

    private fun insertRecursive(curentNode: NodeKt?, value: Int): NodeKt? {
        if (curentNode == null) {
            return NodeKt(value)
        }
        if (value < curentNode.value) {
            curentNode.leftNode = insertRecursive(curentNode.leftNode, value)
        } else if (value > curentNode.value) {
            curentNode.rightNode = insertRecursive(curentNode.rightNode, value)
        } else {
            return curentNode
        }
        return curentNode
    }

    override fun add(value: Int) {
        root = insertRecursive(root, value)
    }

    private fun containsRecursive(curentNode: NodeKt?, value: Int): Boolean {
        if (curentNode == null) {
            return false
        }
        if (curentNode.value == value) {
            return true
        }
        var contains = false
        if (value < curentNode.value) {
            contains = containsRecursive(curentNode.leftNode, value)
        } else if (value > curentNode.value) {
            contains = containsRecursive(curentNode.rightNode, value)
        }
        return contains
    }

    override fun containsNode(value: Int): Boolean {
        return containsRecursive(root, value)
    }

    private fun deleteRecursive(currentNode: NodeKt?, value: Int): NodeKt? {
        if (currentNode == null) {
            return null
        }
        if (value == currentNode.value) {
            if (currentNode.leftNode == null && currentNode.rightNode == null) {
                return null
            }
            val smallestValue = findSmallestValue(currentNode.rightNode)
            currentNode.value = smallestValue
            currentNode.rightNode = deleteRecursive(currentNode.rightNode, smallestValue)
        }
        if (value < currentNode.value) {
            currentNode.leftNode = deleteRecursive(currentNode.leftNode, value)
            return currentNode
        }
        currentNode.rightNode = deleteRecursive(currentNode.rightNode, value)
        return currentNode
    }

    private fun findSmallestValue(root: NodeKt?): Int {
        return if (root?.leftNode == null) root!!.value else findSmallestValue(root.leftNode)
    }

    override fun deleteNode(value: Int) {
        deleteRecursive(root, value)
    }

    private fun traverseRecursive(node: NodeKt?) {
        if (node != null) {
            println("Value : " + node.value)
            traverseRecursive(node.leftNode)
            traverseRecursive(node.rightNode)
        }
    }

    override fun traverse() {
        traverseRecursive(root)
    }

    override fun traverseLevel() {
        val nodes: Queue<NodeKt?> = LinkedList()
        nodes.add(root)

        while (!nodes.isEmpty()) {
            val node = nodes.remove()
            println("Value : " + node!!.value)

            if (node.leftNode != null) {
                nodes.add(node.leftNode)
            }
            if (node.rightNode != null) {
                nodes.add(node.rightNode)
            }
        }
    }
}