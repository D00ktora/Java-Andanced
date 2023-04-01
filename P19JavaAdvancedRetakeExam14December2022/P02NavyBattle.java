/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.4.2023 г.
 * Time: 7:53
 */
package P19JavaAdvancedRetakeExam14December2022;

import java.util.Scanner;

public class P02NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        char[][] battlefield = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] split = input.split("");
            char[] splited = new char[n];
            for (int j = 0; j < n; j++) {
                splited[j] = split[j].charAt(0);
            }
            battlefield[i] = splited;
        }

        int submarineRow = findeRow(battlefield);
        int submarineCol = findeCol(battlefield);
        int battleCruisersCount = countBattleCruisers(battlefield);
        int submarineLive = 3;

        while (submarineLive > 0 && battleCruisersCount > 0) {
            String command = scanner.nextLine();
            int row = -1;
            int col = -1;
            if (command.contains("up")) {
                row = submarineRow - 1;
                col = submarineCol;
            } else if (command.contains("down")) {
                row = submarineRow + 1;
                col = submarineCol;
            } else if (command.contains("left")) {
                row = submarineRow;
                col = submarineCol - 1;
            } else if (command.contains("right")) {
                row = submarineRow;
                col = submarineCol + 1;
            }
            char mark = checkMark(row, col, battlefield);

                switch (mark) {
                    case '-':
                        battlefield[submarineRow][submarineCol] = '-';
                        battlefield[row][col] = 'S';
                        submarineRow = row;
                        submarineCol = col;
                        break;
                    case '*':
                        battlefield[submarineRow][submarineCol] = '-';
                        battlefield[row][col] = 'S';
                        submarineLive--;
                        submarineRow = row;
                        submarineCol = col;
                        if (submarineLive == 0) {
                            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", submarineRow, submarineCol);
                            printmatrix(battlefield);
                            return;
                        }
                        break;
                    case 'C':
                        battlefield[submarineRow][submarineCol] = '-';
                        battlefield[row][col] = 'S';
                        battleCruisersCount--;
                        submarineRow = row;
                        submarineCol = col;
                        if (battleCruisersCount == 0) {
                            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                            printmatrix(battlefield);
                            return;
                        }
                        break;
                }
            }


        System.out.println();
    }

    private static void printmatrix(char[][] battlefield) {
        for (char[] chars : battlefield) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static char checkMark(int row, int col, char[][] battlefield) {
        return battlefield[row][col];
    }

    private static int countBattleCruisers(char[][] battlefield) {
        int result = 0;
        for (char[] chars : battlefield) {
            for (char aChar : chars) {
                if (aChar == 'C') {
                    result++;
                }
            }
        }
        return result;
    }


    private static int findeCol(char[][] battlefield) {
        for (int i = 0; i < battlefield.length; i++) {
            char[] temp = battlefield[i];
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == 'S') {
                    return j;
                }
            }
        }
        return -1;
    }

    private static int findeRow(char[][] battlefield) {
        for (int i = 0; i < battlefield.length; i++) {
            char[] temp = battlefield[i];
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == 'S') {
                    return i;
                }
            }
        }
        return -1;
    }
}
