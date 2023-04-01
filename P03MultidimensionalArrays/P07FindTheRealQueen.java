/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 3.3.2023 г.
 * Time: 9:25
 */
package P03MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = new String[8][8];
        for (int i = 0; i < 8; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < inputLine.length; j++) {
                matrix[i][j] = inputLine[j];
            }
        }

        List<String> positions = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("q")) {
                    String pos = i + " " + j;
                    positions.add(pos);
                }
            }
        }

        for (String position : positions) {
            int row = Integer.parseInt(position.split(" ")[0]);
            int col = Integer.parseInt(position.split(" ")[1]);

            if (checkDiagonals(matrix,row,col) && checkRow(matrix,row,col) && checkCol(matrix,row,col)) {
                System.out.println(position);
                return;
            }
        }
    }

    private static boolean checkCol(String[][] matrix, int row, int col) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i].equals("q") && i != col) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRow(String[][] matrix, int row, int col) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col].equals("q") && i != row) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDiagonals(String[][] matrix, int row, int col) {
        if (upLeft(matrix,row,col) && upRight(matrix,row,col) && downLeft(matrix,row,col) && downRight(matrix,row,col)) {
            return true;
        }
        return false;
    }

    private static boolean downRight(String[][] matrix, int row, int col) {
        row++;
        col++;
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix.length) {
            if (matrix[row][col].equals("q")) {
                return false;
            }
            row++;
            col++;
        }
        return true;
    }

    private static boolean downLeft(String[][] matrix, int row, int col) {
        row++;
        col--;
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix.length) {
            if (matrix[row][col].equals("q")) {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

    private static boolean upRight(String[][] matrix, int row, int col) {
        row--;
        col++;
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix.length) {
            if (matrix[row][col].equals("q")) {
                return false;
            }
            row--;
            col++;
        }
        return true;
    }

    private static boolean upLeft(String[][] matrix, int row, int col) {
        row--;
        col--;
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix.length) {
            if (matrix[row][col].equals("q")) {
                return false;
            }
            row--;
            col--;
        }
        return true;
    }
}
