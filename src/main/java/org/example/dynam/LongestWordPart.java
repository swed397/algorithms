package org.example.dynam;

import java.util.List;

public class LongestWordPart {

    private String wordA;
    private String wordB;
    int[][] matrix;

    public LongestWordPart(String wordA, String wordB) {
        this.wordA = wordA;
        this.wordB = wordB;
        matrix = new int[wordA.length()][wordB.length()];
    }

    public int[][] process() {
        for (int i = 0; i < wordA.length(); i++) {
            for (int j = 0; j < wordB.length(); j++) {
                if (wordA.charAt(i) == wordB.charAt(j)) {
                    if (i > 0 && j > 0) {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    } else {
                        matrix[i][j] = 1;
                    }
                } else {
                    if (i == 0 && j > 0) {
                        matrix[i][j] = matrix[i][j - 1];
                    } else if (i > 0 && j == 0) {
                        matrix[i][j] = matrix[i - 1][j];
                    } else if (i > 0 && j > 0) {
                        matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                    }
                }
            }
        }

        return matrix;
    }
}
