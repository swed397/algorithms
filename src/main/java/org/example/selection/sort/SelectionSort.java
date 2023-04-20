package org.example.selection.sort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    private Integer findSmallest(List<Integer> list) {
        Integer smallestValue = list.get(0);
        Integer smallestPos = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < smallestValue) {
                smallestValue = list.get(i);
                smallestPos = i;
            }
        }

        return smallestPos;
    }

    public List<Integer> sort(List<Integer> list) {
        List<Integer> newArr = new ArrayList<>(list.size());
        var listSize = list.size();

        for (int i = 0; i < listSize; i++) {
            int smallestIndex = findSmallest(list);
            newArr.add(list.get(smallestIndex));
            list.remove(smallestIndex);
        }

        return newArr;
    }
}
