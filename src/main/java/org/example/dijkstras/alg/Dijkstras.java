package org.example.dijkstras.alg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstras {

    private final List<String> proceed = new ArrayList<>();
    private final HashMap<String, Map<String, Integer>> graphMap;
    private final HashMap<String, Integer> costMap;
    private final HashMap<String, String> parentMap;

    public Dijkstras(HashMap<String, Map<String, Integer>> graphMap,
                     HashMap<String, Integer> costMap, HashMap<String, String> parentMap) {
        this.graphMap = graphMap;
        this.costMap = costMap;
        this.parentMap = parentMap;
    }

    public HashMap<String, Integer> process() {
        String node = findTheLowestCostNode(costMap);

        while (graphMap.get(node) != null) {
            Integer cost = costMap.get(node);
            Map<String, Integer> neighbours = graphMap.get(node);

            for (String n : neighbours.keySet()) {
                var newCost = cost + neighbours.get(n);
                if (costMap.get(n) > newCost) {
                    costMap.put(n, newCost);
                    parentMap.put(n, node);
                }
            }

            proceed.add(node);
            node = findTheLowestCostNode(costMap);
        }

        return costMap;
    }

    private String findTheLowestCostNode(HashMap<String, Integer> costMap) {
        Integer lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = null;

        for (Map.Entry<String, Integer> node : costMap.entrySet()) {
            var cost = node.getValue();

            if (cost < lowestCost && !proceed.contains(node.getKey())) {
                lowestCost = cost;
                lowestCostNode = node.getKey();
            }
        }

        return lowestCostNode;

    }
}
