import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nikolotov.testtask.randomarray.RandomArray;

import java.util.HashSet;
import java.util.Set;

public class Tests {
    @Test
    public void matrixSizeTest() {
        int n = 10;
        int[][] matrix = RandomArray.getRandomMatrix(n);
        Assertions.assertEquals(n, matrix.length);

        n = 1;
        matrix = RandomArray.getRandomMatrix(n);
        Assertions.assertEquals(n, matrix.length);

        n = 0;
        matrix = RandomArray.getRandomMatrix(n);
        Assertions.assertNull(matrix);

        n = -1;
        matrix = RandomArray.getRandomMatrix(n);
        Assertions.assertNull(matrix);

        n = 1000; //more than MAX_LENGTH_OF_ARRAY
        matrix = RandomArray.getRandomMatrix(n);
        Assertions.assertNull(matrix);
    }

    @Test
    public void uniqueArraysTest() {
        int n = 100;
        Set<Integer> lengths = new HashSet<>(100);
        int[][] matrix = RandomArray.getRandomMatrix(n);
        Assertions.assertEquals(matrix.length, n);

        for (int i = 0; i < matrix.length; i++) {
            lengths.add(matrix[i].length);
        }
        Assertions.assertEquals(n, lengths.size());
    }

    @Test
    public void correctSortTest() {
        int n = 100;
        int[][] matrix = RandomArray.getRandomMatrix(n);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (i % 2 == 0) {
                    Assertions.assertTrue(matrix[i][j - 1] <= matrix[i][j]);
                } else {
                    Assertions.assertTrue(matrix[i][j - 1] >= matrix[i][j]);
                }
            }
        }
    }

}
