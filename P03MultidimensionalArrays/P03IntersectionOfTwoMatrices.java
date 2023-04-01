/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 3.3.2023 г.
 * Time: 9:24
 */
package P03MultidimensionalArrays;

import java.awt.*;
import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());
        char[][] matrix1 = new char[row][col];
        char[][] matrix2 = new char[row][col];

        for (int i = 0; i < row; i++) {
            String[] chars = scanner.nextLine().split(" ");
            for (int j = 0; j < chars.length; j++) {
                matrix1[i][j] = chars[j].charAt(0);
            }
        }
        for (int i = 0; i < row; i++) {
            String[] chars = scanner.nextLine().split(" ");
            for (int j = 0; j < chars.length; j++) {
                matrix2[i][j] = chars[j].charAt(0);
            }
        }
        char[][] resultMatrix = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix1[i][j] == matrix2[i][j]){
                    resultMatrix[i][j] = matrix1[i][j];
                } else {
                    resultMatrix[i][j] = '*';
                }
            }
        }

        for (char[] matrix : resultMatrix) {
            for (char c : matrix) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
