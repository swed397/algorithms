package org.example.graphs;

import java.util.*;

public class SimpleBreadthSearch {

    private final HashMap<String, List<String>> graph = new HashMap<>();
    private String sellerName;

    public SimpleBreadthSearch() {
    }

    public String searchSeller() {
        Queue<String> searchQueue = new ArrayDeque<>(graph.get("You"));
        var checkedList = new ArrayList<String>();

        while (searchQueue.size() != 0) {
            var person = searchQueue.poll();

            if (!checkedList.contains(person)) {
                if (person.equals(sellerName)) {
                    return person;
                } else {
                    searchQueue.addAll(graph.get(person));
                }
            }

            checkedList.add(person);
        }

        return "No one seller in graph";
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public HashMap<String, List<String>> getGraph() {
        return graph;
    }
}
