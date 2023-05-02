package org.example.graphs;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        var simpleBreadthSearch = new SimpleBreadthSearch();
        simpleBreadthSearch.setSellerName("Clair");
        var graph = simpleBreadthSearch.getGraph();

        graph.put("You", List.of("Alice", "Bob", "Clair"));
        graph.put("Bob", List.of("Anuge", "Peggy"));
        graph.put("Alice", List.of("Peggy"));
        graph.put("Clair", List.of("Tom", "Jonny"));
        graph.put("Anuge", List.of());
        graph.put("Peggy", List.of());
        graph.put("Tom", List.of());
        graph.put("Jonny", List.of());

        System.out.println(simpleBreadthSearch.searchSeller());
    }
}
