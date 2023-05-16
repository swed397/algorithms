package org.example.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        var states = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        var stations = new HashMap<String, HashSet<String>>();

        stations.put("kone", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("kthree", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kfour", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kfive", new HashSet<>(Arrays.asList("ca", "az")));

        Covering covering = new Covering(states, stations);
        System.out.println("Result : " + covering.proceed());
    }
}
