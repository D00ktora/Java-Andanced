/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 3.3.2023 г.
 * Time: 9:23
 */
package P03MultidimensionalArrays;

import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int number = scanner.nextInt();
        boolean isNotFound = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == number) {
                    System.out.println(i + " " + j);
                    isNotFound = false;
                }
            }
        }
        if (isNotFound) {
            System.out.println("not found");
        }
    }
}
