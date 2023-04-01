/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 30.3.2023 г.
 * Time: 19:25
 */
package P18JavaAdvancedExam18February2023;

import java.util.Arrays;
import java.util.Scanner;

public class P02BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];
        char[][] playGround = new char[n][m];
        int[] playerPosition = new int[2];
        int moves = 0;
        int touchedPlayers = 0;

        readPlayGround(scanner, n, playGround);
        playerPosition = findePlayer(playGround, playerPosition);


        String command = scanner.nextLine();

        while (!command.contains("Finish")) {
            switch (command) {
                case "up":
                    int rowUP = playerPosition[0] - 1;
                    int colUP = playerPosition[1];
                    if (checkIfIsInside(rowUP, colUP,playGround)) {
                        if (!checkForObstical(playGround[rowUP][colUP])) {
                            if (checkIfIsPlayer(playGround[rowUP][colUP])) {
                                playGround[playerPosition[0]][playerPosition[1]] = '-';
                                playGround[rowUP][colUP] = 'B';
                                moves++;
                                touchedPlayers++;
                                playerPosition[0] = rowUP;
                                playerPosition[1] = colUP;
                            } else {
                                playGround[playerPosition[0]][playerPosition[1]] = '-';
                                playGround[rowUP][colUP] = 'B';
                                playerPosition[0] = rowUP;
                                playerPosition[1] = colUP;
                                moves++;
                            }
                        }
                    }
                        break;
                case "down":
                    int rowDown = playerPosition[0] + 1;
                    int colDown = playerPosition[1];
                    if (checkIfIsInside(rowDown, colDown,playGround)) {
                        if (!checkForObstical(playGround[rowDown][colDown])) {
                            if (checkIfIsPlayer(playGround[rowDown][colDown])) {
                                playGround[playerPosition[0]][playerPosition[1]] = '-';
                                playGround[rowDown][colDown] = 'B';
                                moves++;
                                touchedPlayers++;
                                playerPosition[0] = rowDown;
                                playerPosition[1] = colDown;
                            } else {
                                playGround[playerPosition[0]][playerPosition[1]] = '-';
                                playGround[rowDown][colDown] = 'B';
                                moves++;
                                playerPosition[0] = rowDown;
                                playerPosition[1] = colDown;
                            }
                        }
                    }
                    break;
                case "right":
                    int rowRight = playerPosition[0];
                    int colRight = playerPosition[1] + 1;
                    if (checkIfIsInside(rowRight, colRight,playGround)) {
                        if (!checkForObstical(playGround[rowRight][colRight])) {
                            if (checkIfIsPlayer(playGround[rowRight][colRight])) {
                                playGround[playerPosition[0]][playerPosition[1]] = '-';
                                playGround[rowRight][colRight] = 'B';
                                moves++;
                                touchedPlayers++;
                                playerPosition[0] = rowRight;
                                playerPosition[1] = colRight;
                            } else {
                                playGround[playerPosition[0]][playerPosition[1]] = '-';
                                playGround[rowRight][colRight] = 'B';
                                moves++;
                                playerPosition[0] = rowRight;
                                playerPosition[1] = colRight;
                            }
                        }
                    }
                    break;
                case "left":
                    int rowLeft = playerPosition[0];
                    int colLeft = playerPosition[1] - 1;
                    if (checkIfIsInside(rowLeft, colLeft,playGround)) {
                        if (!checkForObstical(playGround[rowLeft][colLeft])) {
                            if (checkIfIsPlayer(playGround[rowLeft][colLeft])) {
                                playGround[playerPosition[0]][playerPosition[1]] = '-';
                                playGround[rowLeft][colLeft] = 'B';
                                moves++;
                                touchedPlayers++;
                                playerPosition[0] = rowLeft;
                                playerPosition[1] = colLeft;
                            } else {
                                playGround[playerPosition[0]][playerPosition[1]] = '-';
                                playGround[rowLeft][colLeft] = 'B';
                                moves++;
                                playerPosition[0] = rowLeft;
                                playerPosition[1] = colLeft;
                            }
                        }
                    }
                    break;
            }
            if (checkForOponent(playGround)) {
                break;
            }
            command = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.println("Touched opponents: " +
                touchedPlayers +
                " Moves made: " +
                moves);
    }

    private static boolean checkForOponent(char[][] playGround) {
        for (char[] chars : playGround) {
            for (char aChar : chars) {
                if (aChar == 'P') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkIfIsPlayer(char c) {
        if (c == 'P') {
            return true;
        }
        return false;
    }

    private static boolean checkForObstical(char c) {
        if (c == 'O') {
            return true;
        }
        return false;
    }


    private static boolean checkIfIsInside(int row, int col, char[][] playGround) {
        if (row >= 0
                && col >= 0
                && row < playGround.length
                && col < playGround[row].length) {
            return true;
        }
        return false;
    }

    private static int[] findePlayer(char[][] playGround, int[] playerPosition) {
        for (int i = 0; i < playGround.length; i++) {
            for (int j = 0; j < playGround[i].length; j++) {
                if (playGround[i][j] == 'B') {
                    playerPosition[0] = i;
                    playerPosition[1] = j;
                    return playerPosition;
                }
            }
        }
        return playerPosition;
    }

    private static void readPlayGround(Scanner scanner, int n, char[][] playGround) {
        for (int i = 0; i < n; i++) {
            String[] chars = scanner.nextLine().split("\\s+");
            char[] charArr = new char[chars.length];
            for (int j = 0; j < chars.length; j++) {
                charArr[j] = chars[j].charAt(0);
            }
            playGround[i] = charArr;
        }
    }
}
