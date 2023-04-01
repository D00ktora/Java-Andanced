/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 3.3.2023 г.
 * Time: 9:23
 */
package P03MultidimensionalArrays;

import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixRows = scanner.nextInt();
        int matrixCols = scanner.nextInt();
        int[][] matrix = new int[matrixRows][matrixCols];
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixCols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        matrixRows = scanner.nextInt();
        matrixCols = scanner.nextInt();
        int[][] matrix2 = new int[matrixRows][matrixCols];
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixCols; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        if (matrix.length != matrix2.length) {
            System.out.println("not equal");
        } else {
            for (int i = 0; i < matrixRows; i++) {
                for (int j = 0; j < matrixCols; j++) {
                    if (matrix[i][j] != matrix2[i][j]){
                        System.out.println("not equal");
                        return;
                    }
                }
            }
            System.out.println("equal");
            return;
        }
    }
}
