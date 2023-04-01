/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 3.3.2023 г.
 * Time: 9:24
 */
package P03MultidimensionalArrays;

import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int row = Integer.parseInt(input.split(", ")[0]);
        int col = Integer.parseInt(input.split(", ")[1]);
        int[][] matrix = new int[row][col];
        int sum = 0;
        for (int i = 0; i < row; i++) {
            String[] inputLine = scanner.nextLine().split(", ");
            for (int j = 0; j < inputLine.length; j++) {
                int number = Integer.parseInt(inputLine[j]);
                matrix[i][j] = number;
                sum += matrix[i][j];
            }
        }
        System.out.println(row);
        System.out.println(col);
        System.out.println(sum);
    }
}
