package org.example.greedy

fun main() {

    val states = hashSetOf("mt", "wa", "or", "id", "nv", "ut", "ca", "az")
    val stations = HashMap<String, HashSet<String>>()

    stations["kone"] = HashSet(mutableListOf("id", "nv", "ut"))
    stations["ktwo"] = HashSet(mutableListOf("wa", "id", "mt"))
    stations["kthree"] = HashSet(mutableListOf("or", "nv", "ca"))
    stations["kfour"] = HashSet(mutableListOf("nv", "ut"))
    stations["kfive"] = HashSet(mutableListOf("ca", "az"))

    val coveringKt = CoveringKt(states, stations)
    println("Result : ${coveringKt.proceed()}")
}

class CoveringKt(
    private var statesSet: Set<String>,
    private val stationsMap: Map<String, HashSet<String>>
) {

    private val finalSet = hashSetOf<String>()

    fun proceed(): HashSet<String> {

        while (statesSet.isNotEmpty()) {
            var bestStation: String? = null
            var statesCovered = setOf<String>()

            for (station in stationsMap) {
                val covered = statesSet.intersect(station.value)

                if (covered.size > statesCovered.size) {
                    bestStation = station.key
                    statesCovered = covered
                }
            }

            statesSet = statesSet - statesCovered
            bestStation?.let { finalSet.add(it) }
        }

        return finalSet
    }
}