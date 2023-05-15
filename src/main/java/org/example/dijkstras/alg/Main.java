package org.example.dijkstras.alg;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        var graphMap = new HashMap<String, Map<String, Integer>>();
        var costMap = new HashMap<String, Integer>();
        var parentMap = new HashMap<String, String>();

        graphMap.put("start", new HashMap<>());
        graphMap.get("start").put("a", 6);
        graphMap.get("start").put("b", 2);

        graphMap.put("a", new HashMap<>());
        graphMap.get("a").put("fin", 1);

        graphMap.put("b", new HashMap<>());
        graphMap.get("b").put("a", 3);
        graphMap.get("b").put("fin", 5);

        graphMap.put("fin", null);

        costMap.put("a", 6);
        costMap.put("b", 2);
        costMap.put("fin", Integer.MAX_VALUE);

        parentMap.put("a", "start");
        parentMap.put("b", "start");
        parentMap.put("fin", null);

        Dijkstras dijkstrasRealise = new Dijkstras(graphMap, costMap, parentMap);
        var finalMap = dijkstrasRealise.process();
        System.out.println("All way " + finalMap);
        System.out.println("Way cost " + finalMap.get("fin"));
    }
}
