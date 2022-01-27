package ru.nikolotov.testtask;

import ru.nikolotov.testtask.randomarray.RandomArray;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Use length of matrix as a parameter");
            return;
        }

        int matrixLength = Integer.parseInt(args[0]);

        var matrix = RandomArray.getRandomMatrix(matrixLength);

        if (matrix != null) {
            for (var array : matrix) {
                System.out.println("Array length: " + array.length);
                for (var element : array) {
                    System.out.print(element + " ");
                }
                System.out.println();
                System.out.println("=====");
            }
        } else {
            System.out.println("Matrix is null");
        }
    }
}
