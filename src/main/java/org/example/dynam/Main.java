package org.example.dynam;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        LongestWordPart longestWordPart = new LongestWordPart("hish", "fish");
        var matrix = longestWordPart.process();

        System.out.println("Matrix longest path : " + Arrays.deepToString(matrix));
        System.out.println("Max longest part value : " + Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .max()
                .getAsInt());
    }
}
