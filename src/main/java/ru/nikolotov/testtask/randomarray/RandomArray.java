package ru.nikolotov.testtask.randomarray;

import java.util.Arrays;;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Andrey Nikolotov
 * @version 1.0
 */
public class RandomArray {
    private static final int MIN_LENGTH_OF_ARRAY = 1;
    private static final int MAX_LENGTH_OF_ARRAY = 101;
    private static final Random random = ThreadLocalRandom.current();

    /**
     * @param arraysAmount - amount of arrays in matrix
     * @return null if arraysAmount <= 0 or arraysAmount > MAX_LENGTH_OF_ARRAY - MIN_LENGTH_OF_ARRAY;
     * Otherwise: matrix with random numbers in which arrays have random unique lengths, even-indexed arrays sorted in natural order, odd-indexed in reversal order
     */
    public static int[][] getRandomMatrix(int arraysAmount) {
        if ((arraysAmount <= 0) || (arraysAmount > MAX_LENGTH_OF_ARRAY - MIN_LENGTH_OF_ARRAY)) {
            return null;
        }

        int[][] matrix = getEmptyMatrix(arraysAmount);
        fillMatrixWithRandomNumbers(matrix);
        sortMatrix(matrix);

        return matrix;
    }

    private static int[][] getEmptyMatrix(int arraysAmount) {
        int[][] matrix = new int[arraysAmount][];

        var lengths = random.ints(MIN_LENGTH_OF_ARRAY, MAX_LENGTH_OF_ARRAY)
                .distinct()
                .limit(arraysAmount)
                .toArray();

        for (int i = 0; i < lengths.length; i++) {
            matrix[i] = new int[lengths[i]];
        }

        return matrix;
    }

    private static void fillMatrixWithRandomNumbers(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt();
            }
        }
    }

    private static void sortMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
            if ((i % 2) == 1) {
                reverseArray(matrix[i]);
            }
        }
    }

    private static void reverseArray(int[] array) {
        int tmp;
        for (int i = 0; i < array.length / 2; i++) {
            tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
    }
}
