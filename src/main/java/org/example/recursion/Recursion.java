package org.example.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Recursion {

    public static void recursionCountDown(Integer value) {
        if (value != 0) {
            System.out.println(value);
            recursionCountDown(value - 1);
        }
    }

    public static Integer sumFromList(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        } else {
            var value = list.get(0);
            list.remove(0);
            return value + sumFromList(list);
        }
    }

    public static Integer listElementCounter(ArrayList<Integer> list) {
        if (list.size() == 0) {
            return 0;
        } else {
            list.remove(0);
            return 1 + listElementCounter(list);
        }
    }

    public static Integer maxElem(ArrayList<Integer> list) {
        if (list.size() == 2) {
            return list.get(0) > list.get(1) ? list.get(0) : list.get(1);
        } else {
            list.remove(0);

            return maxElem(list);
        }
    }

    public static List<Integer> qsort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        } else {
            var pivot = list.get(0);

            List<Integer> less = list.stream().skip(1).filter(el -> el <= pivot).toList();
            List<Integer> greater = list.stream().skip(1).filter(el -> el > pivot).toList();

            return Stream.of(qsort(less).stream(), Stream.of(pivot), qsort(greater).stream())
                    .flatMap(Function.identity()).collect(Collectors.toList());
        }
    }
}
