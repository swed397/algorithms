package org.example.binary.search;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        var limit = 10;

        List<Integer> integerList = new Random()
                .ints(0, 100)
                .limit(limit)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        BinarySearch binarySearch = new BinarySearch(integerList);

        var randomInt = new Random().nextInt(0, limit);
        var randomIntFromList = integerList.get(randomInt);
        var pos = binarySearch.getPosition(randomIntFromList);

        System.out.println("List: " + integerList);
        System.out.println("Random int from list: " + randomIntFromList);
        System.out.println("Pos " + pos);
    }
}
