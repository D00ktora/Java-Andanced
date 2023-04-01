/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 6:08
 */
package P04MultidimensionalArraysExercises;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        String[][] matrix = new String[row][col];
        String temp = "";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char toAdd = (char) ('a' + i);
                temp += toAdd;
                toAdd = (char) ('a' + i + j);
                temp += toAdd;
                toAdd = (char) ('a' + i);
                temp += toAdd;
                matrix[i][j] = temp;
                temp = "";
            }
        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.printf("%s ",string);
            }
            System.out.println();
        }
    }
}
