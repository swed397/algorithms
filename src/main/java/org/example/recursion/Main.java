package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Recursion.recursionCountDown(5);

        var list = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };

        var sum = Recursion.sumFromList(list);
        System.out.println("List sum: " + sum);

        var list2 = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
        var listCounter = Recursion.listElementCounter(list2);
        System.out.println("List elem count: " + listCounter);

        var list3 = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
        var maxElem = Recursion.listElementCounter(list3);
        System.out.println("List max elem: " + maxElem);

        var listToQSort = List.of(1, 5, 7, 3, 9);
        System.out.println("Qsort " + Recursion.qsort(listToQSort));
    }
}
