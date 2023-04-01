/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 5:27
 */
package P04MultidimensionalArraysExercises;

import java.util.Collections;
import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(", ");
        int number = Integer.parseInt(split[0]);
        String variant = split[1];
        
        String[] numbers = new String[number];
        String newLine = "";
        int position = 0;
        for (int i = 1; i <= number * number; i++) {
            newLine += i + " ";

            if (i % number == 0) {
                numbers[position] = newLine;
                newLine = "";
                position++;
            }
        }

        int[][] matrix = new int[number][number];
        if (variant.contains("A")) {
            for (int i = 0; i < number; i++) {
                String[] line = numbers[i].split(" ");
                for (int j = 0; j < number; j++) {
                    matrix[j][i] = Integer.parseInt(line[j]);
                }
            }
        } else if (variant.contains("B")) {
            for (int i = 0; i < number; i++) {
                if (i % 2 != 0) {
                    String[] temp = numbers[i].substring(0, numbers[i].length()).trim().split(" ");
                    String tempString = "";
                    for (int j = temp.length - 1; j >= 0; j--) {
                        tempString += temp[j] + " ";
                    }
                    String[] reversLine = tempString.split("\\s+");

                    for (int j = 0; j < number; j++) {
                        matrix[j][i] = Integer.parseInt(reversLine[j]);
                    }
                } else {
                    String[] temp = numbers[i].split("\\s+");
                    for (int j = 0; j < number; j++) {
                        matrix[j][i] = Integer.parseInt(temp[j]);
                    }
                }
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%d ",anInt);
            }
            System.out.println();
        }
    }
}
