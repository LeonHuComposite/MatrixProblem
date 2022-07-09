package com.learn;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Please enter the size of a matrix?");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] array = findPerfectMatrix(n);
        print(array);
    }

    public static int[][] findPerfectMatrix(int n) {
        if (n == 0) return null;

        int times = 0;
        boolean allEquals = false;
        int[][] matrix = new int[n][n];
        do {
            times++;
            if ( times % 1000 == 0 ) {
                System.out.println("times=" + times);
            }
            matrix = generateTwoDimArray(n);
            allEquals = isSumOfAllRowsAndColumnsEqual(matrix);
        } while (!allEquals);

        return matrix;
    }

    public static boolean isSumOfAllRowsAndColumnsEqual(int[][] matrix) {
        int firstRowSum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            firstRowSum = firstRowSum + matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                rowSum = rowSum + matrix[i][j];
            }
            if (firstRowSum != rowSum) return false;
        }


        for (int i = 0; i < matrix[0].length; i++) {
            int colSum = 0;
            for (int j = 0; j < matrix.length; j++) {
                colSum = colSum + matrix[j][i];
            }
            if (colSum != firstRowSum) return false;
        }
        return true;

    }

    public static int[][] generateTwoDimArray(int square) {
        int[] RandomArray = generateRandomArray(square * square);
        int[][] RandomTwoDimArray = convertToTwoDim(RandomArray, square, square);
        return RandomTwoDimArray;
    }

    public static int[] generateRandomArray(int len) {
        if (len == 0) return null;
        int[] increase = new int[len];
        int[] result = new int[len];
        int[] array = increase;
        for (int i = 0; i < len; i++) {
            increase[i] = i + 1;
        }
        for (int i = 0; i <= len - 1; i++) {

            double d = array.length * Math.random();
            int extract = (int) Math.floor(d);
            if (i != len) {
                result[i] = array[extract];
            } else {
                result[i] = array[extract - 1];
            }
            array = removeElementAt(array, extract);

        }
        return result;
    }

    public static int[][] convertToTwoDim(int[] array, int row, int col) {

        if (row * col != array.length || array == null) return null;

        int[][] newArray = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int a = i * col + j;
                newArray[i][j] = array[a];
            }
        }

        return newArray;
    }

    public static void print(int[][] array) {
        if (array == null) {
            System.out.println("array is null");
            return;
        }
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void print(int[] array) {
        System.out.println("");
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                System.out.print(" ");
            }
            System.out.println("");
        } else {
            System.out.println("input array is null");
        }
    }

    public static int[] generate(int max) {
        int[] array = new int[max];

        if (max < 1) return null;
        for (int i = 1; i <= max; i++) {
            array[i - 1] = i;
        }
        return array;
    }

    public static int[] removeElementAt(int[] array, int index) {
        if (index >= array.length || index < 0) return null;
        int newarray[] = new int[array.length - 1];
        int a = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (i != index && a == 0) {
                newarray[i] = array[i];
            } else {
                a = 1;
                newarray[i] = array[i + 1];
            }
        }
        return newarray;
    }

}