package org.example.selection.sort;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        var arrayToSort = new ArrayList<Integer>() {
            {
                add(5);
                add(2);
                add(7);
                add(9);
                add(0);
                add(1);
            }
        };

        SelectionSort selectionSort = new SelectionSort();
        var sortedArr = selectionSort.sort(arrayToSort);

        System.out.println(sortedArr);
    }
}
