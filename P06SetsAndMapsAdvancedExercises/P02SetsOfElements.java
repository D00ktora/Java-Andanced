/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 17:20
 */
package P06SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        String[] input = scanner.nextLine().split(" ");
        int numberOfFIrstSet = Integer.parseInt(input[0]);
        int numberOfSecondSet = Integer.parseInt(input[1]);

        for (int i = 0; i < numberOfFIrstSet; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        for (int i = 0; i < numberOfSecondSet; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        if (firstSet.size() > secondSet.size()) {
            for (Integer integer : secondSet) {
                if (firstSet.contains(integer)) {
                    System.out.print(integer + " ");
                }
            }
        } else {
            for (Integer integer : firstSet) {
                if (secondSet.contains(integer)) {
                    System.out.print(integer + " ");
                }
            }
        }
    }
}
