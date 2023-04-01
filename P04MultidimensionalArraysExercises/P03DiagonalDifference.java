/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 6:18
 */
package P04MultidimensionalArraysExercises;

import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[number][number];

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int primDiagonal = findPrimDiagonal(matrix);
        int secondDiagonal = findSecondDiagonal(matrix);
        int difference = Math.abs(primDiagonal - secondDiagonal);
        System.out.println(difference);
    }

    private static int findSecondDiagonal(int[][] matrix) {
        int sum = 0;
        int change = matrix.length;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == matrix.length - change) {
                    sum += matrix[i][j];
                }
            }
            change--;
        }
        return sum;
    }

    private static int findPrimDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }
}
