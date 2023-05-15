package org.example.dijkstras.alg

fun main() {

    val graphMap = mutableMapOf<String, MutableMap<String, Int>?>()
    val costMap = mutableMapOf<String, Int>()
    val parentMap = mutableMapOf<String, String?>()

    graphMap["start"] = HashMap()
    graphMap["start"]!!["a"] = 6
    graphMap["start"]!!["b"] = 2

    graphMap["a"] = HashMap()
    graphMap["a"]!!["fin"] = 1

    graphMap["b"] = HashMap()
    graphMap["b"]!!["a"] = 3
    graphMap["b"]!!["fin"] = 5

    graphMap["fin"] = null

    costMap["a"] = 6
    costMap["b"] = 2
    costMap["fin"] = Int.MAX_VALUE

    parentMap["a"] = "start"
    parentMap["b"] = "start"
    parentMap["fin"] = null

    val dijkstrasRealise = DijkstrasKt(graphMap, costMap, parentMap)
    val finalMap = dijkstrasRealise.process()
    println("All way $finalMap")
    println("Way cost " + finalMap["fin"])
}

class DijkstrasKt(
    var graphMap: MutableMap<String, MutableMap<String, Int>?>,
    var costMap: MutableMap<String, Int>,
    var parentMap: MutableMap<String, String?>
) {
    val proceed = mutableListOf<String?>()

    fun process(): MutableMap<String, Int> {
        var node: String? = findTheLowestCostNode(costMap)

        while (graphMap[node] != null) {
            val cost = costMap[node]
            val neighbours = graphMap[node]
            for (n in neighbours!!.keys) {
                val newCost = cost!! + neighbours[n]!!
                if (costMap[n]!! > newCost) {
                    costMap[n] = newCost
                    parentMap[n] = node
                }
            }

            proceed.add(node)
            node = findTheLowestCostNode(costMap)
        }

        return costMap
    }

    private fun findTheLowestCostNode(costMap: MutableMap<String, Int>): String? {
        var lowestCost = Int.MAX_VALUE
        var lowestCostNode: String? = null

        for ((key, cost) in costMap) {
            if (cost < lowestCost && !proceed.contains(key)) {
                lowestCost = cost
                lowestCostNode = key
            }
        }
        return lowestCostNode
    }
}