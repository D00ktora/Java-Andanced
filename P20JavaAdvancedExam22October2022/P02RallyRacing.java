/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.4.2023 г.
 * Time: 16:57
 */
package P20JavaAdvancedExam22October2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] track= new char[n][n];
        String carNumber = scanner.nextLine();
        int carDistance = 0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] split = line.split("\\s+");
            char[] charLine = new char[n];
            for (int j = 0; j < split.length; j++) {
                charLine[j] = split[j].charAt(0);
            }
            track[i] = charLine;
        }

        List<Integer> carPosition = new ArrayList<>();
        carPosition.add(0);
        carPosition.add(0);
        List<Integer> tunnel1Position = new ArrayList<>();
        List<Integer> tunnel2Position = new ArrayList<>();
        List<Integer> finishLine = new ArrayList<>();
        findTunels(tunnel1Position, tunnel2Position, track);
        findFinishLine(finishLine, track);

        track[0][0] = 'C';
        String command = scanner.nextLine();
        while (!command.contains("End")) {
            int row = -1;
            int col = -1;
            if (command.equals("up")) {
                row = carPosition.get(0) - 1;
                col = carPosition.get(1);
            } else if (command.equals("down")){
                row = carPosition.get(0) + 1;
                col = carPosition.get(1);
            } else if (command.equals("left")) {
                row = carPosition.get(0);
                col = carPosition.get(1) - 1;
            }else if (command.equals("right")) {
                row = carPosition.get(0);
                col = carPosition.get(1) + 1;
            }

            if (track[row][col] == '.') {
                carDistance += 10;
                track[row][col] = 'C';
                track[carPosition.get(0)][carPosition.get(1)] = '.';
                carPosition.add(0, row);
                carPosition.add(1, col);
            } else if (track[row][col] == 'T') {
                if (row == tunnel1Position.get(0) && col == tunnel1Position.get(1)) {
                    track[carPosition.get(0)][carPosition.get(1)] = '.';
                    track[tunnel2Position.get(0)][tunnel2Position.get(1)] = 'C';
                    carPosition.add(0, tunnel2Position.get(0));
                    carPosition.add(1, tunnel2Position.get(1));
                    carDistance += 30;
                    track[row][col] = '.';
                    //track[tunnel2Position.get(0)][tunnel2Position.get(1)] = '.';
                } else {
                    track[carPosition.get(0)][carPosition.get(1)] = '.';
                    track[tunnel1Position.get(0)][tunnel1Position.get(1)] = 'C';
                    carPosition.add(0, tunnel1Position.get(0));
                    carPosition.add(1, tunnel1Position.get(1));
                    carDistance += 30;
                    //track[row][col] = '.';
                    //track[tunnel1Position.get(0)][tunnel1Position.get(1)] = '.';
                }
            } else if (track[row][col] == 'F') {
                carDistance += 10;
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                track[carPosition.get(0)][carPosition.get(1)] = '.';
                track[row][col] = 'C';
                carPosition.add(0, row);
                carPosition.add(1, col);
                break;
            }


            command = scanner.nextLine();
        }

        int carPosRow = carPosition.get(0);
        int carPosCol = carPosition.get(1);
        int finishRow = finishLine.get(0);
        int finishCol = finishLine.get(1);
        if (carPosRow != finishRow || carPosCol != finishCol) {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }

        System.out.printf("Distance covered %d km.%n", carDistance);
        for (char[] line : track) {
            for (char ch : line) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    private static void findFinishLine(List<Integer> finishLine, char[][] track) {
        for (int i = 0; i < track.length; i++) {
            char[] temp = track[i];
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == 'F') {
                    finishLine.add(i);
                    finishLine.add(j);
                    break;
                }
            }
        }
    }

    private static void findTunels(List<Integer> tunnel1Position, List<Integer> tunnel2Position, char[][] track) {
        for (int i = 0; i < track.length; i++) {
            char[] temp = track[i];
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == 'T' && tunnel1Position.isEmpty()) {
                    tunnel1Position.add(i);
                    tunnel1Position.add(j);
                } else if (temp[j] == 'T'){
                    tunnel2Position.add(i);
                    tunnel2Position.add(j);
                    break;
                }
            }
        }
    }
}
