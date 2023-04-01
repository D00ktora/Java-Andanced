/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 17:27
 */
package P06SetsAndMapsAdvancedExercises;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        String line = "";

        for (int i = 0; i < numberOfLines; i++) {
            line += scanner.nextLine() + " ";
        }

        String[] elements = line.split("\\s+");

        Set<String> table = new TreeSet<>();

        for (String element : elements) {
            table.add(element);
        }

        System.out.println(String.join(" ", table));
    }
}
