/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 3.3.2023 г.
 * Time: 9:24
 */
package P03MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int row = Integer.parseInt(input.split(", ")[0]);
        int col = Integer.parseInt(input.split(", ")[1]);
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] inputLine = scanner.nextLine().split(", ");
            for (int j = 0; j < inputLine.length; j++) {
                int number = Integer.parseInt(inputLine[j]);
                matrix[i][j] = number;
            }
        }

        List<int[][]> matrixList = new ArrayList<>();

        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                int[][] tempMatrix = new int[2][2];
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        tempMatrix[k][l] = matrix[i+k][j+l];
                    }
                }
                matrixList.add(tempMatrix);
            }
        }
        System.out.println();
        int maxSum = 0;
        int[][] matrixForPrint = new int[2][2];
        for (int[][] ints : matrixList) {
            int sum = 0;
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    sum += i;
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                matrixForPrint = ints;
            }
        }

        for (int[] ints : matrixForPrint) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
