package org.example.graphs

import java.util.ArrayDeque


fun main() {

    val simpleBreadthSearch = SimpleBreadthSearchKt()
    simpleBreadthSearch.sellerName = "Clair"
    val graph = simpleBreadthSearch.graph

    graph["You"] = listOf("Alice", "Bob", "Clair")
    graph["Bob"] = listOf("Anuge", "Peggy")
    graph["Alice"] = listOf("Peggy")
    graph["Clair"] = listOf("Tom", "Jonny")
    graph["Anuge"] = listOf()
    graph["Peggy"] = listOf()
    graph["Tom"] = listOf()
    graph["Jonny"] = listOf()

    println(simpleBreadthSearch.searchSeller())
}

class SimpleBreadthSearchKt {

    val graph: HashMap<String, List<String>> = HashMap()
    var sellerName = ""

    fun searchSeller(): String {
        val searchQueue = ArrayDeque(graph["You"])
        val checkedList = mutableListOf<String>()

        while (searchQueue.size != 0) {
            val person = searchQueue.poll()

            if (!checkedList.contains(person)) {
                if (person == sellerName) {
                    return person
                } else {
                    graph[person]?.let { searchQueue.addAll(it) }
                }
            }

            checkedList.add(person)
        }

        return "No one seller in graph"
    }

}