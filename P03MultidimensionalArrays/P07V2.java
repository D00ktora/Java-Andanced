/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 3.3.2023 г.
 * Time: 18:47
 */
package P03MultidimensionalArrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class P07V2 {
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

            int downRightRow = row + 1;
            int downRightCol = col +1;
            while (downRightRow >= 0 && downRightRow < matrix.length && downRightCol >= 0 && downRightCol < matrix.length) {
                if (matrix[downRightRow][downRightCol].equals("q")) {
                    return false;
                }
                downRightRow++;
                downRightCol++;
            }


            int downLeftRow = row + 1;
            int downLeftCol = col-1;
            while (downLeftRow >= 0 && downLeftRow < matrix.length && downLeftCol >= 0 && downLeftCol < matrix.length) {
                if (matrix[downLeftRow][downLeftCol].equals("q")) {
                    return false;
                }
                downLeftRow++;
                downLeftCol--;
            }


            int upRightRow = row - 1;
            int upRightCol = col + 1;
            while (upRightRow >= 0 && upRightRow < matrix.length && upRightCol >= 0 && upRightCol < matrix.length) {
                if (matrix[upRightRow][col].equals("q")) {
                    return false;
                }
                upRightRow--;
                upRightCol++;
            }


            int upLeftRow = row - 1;
            int upLeftCol = col - 1;
            while (upLeftRow >= 0 && upLeftRow < matrix.length && upLeftCol >= 0 && upLeftCol < matrix.length) {
                if (matrix[upLeftRow][col].equals("q")) {
                    return false;
                }
                upLeftRow--;
                upLeftCol--;
            }
        return true;
    }

}
