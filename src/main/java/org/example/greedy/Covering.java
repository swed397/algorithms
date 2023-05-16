package org.example.greedy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Covering {

    private final Map<String, HashSet<String>> stationsMap;
    private final HashSet<String> statesSet;
    private final HashSet<String> finalSet = new HashSet<>();

    public Covering(HashSet<String> statesSet, Map<String, HashSet<String>> stationsMap) {
        this.statesSet = statesSet;
        this.stationsMap = stationsMap;
    }

    public Set<String> proceed() {
        while (statesSet.size() != 0) {
            String bestStation = null;
            HashSet<String> statesCovered = new HashSet<>();

            for (var station : stationsMap.entrySet()) {
                HashSet<String> covered = new HashSet<>(statesSet);
                covered.retainAll(station.getValue());

                if (covered.size() > statesCovered.size()) {
                    bestStation = station.getKey();
                    statesCovered = covered;
                }
            }
            statesSet.removeIf(statesCovered::contains);

            if (bestStation != null) {
                finalSet.add(bestStation);
            }
        }

        return finalSet;
    }

}
