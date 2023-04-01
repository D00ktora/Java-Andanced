/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 17:44
 */
package P06SetsAndMapsAdvancedExercises;

import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.contains("stop")) {
            String address = scanner.nextLine();
            String end = address.split("\\.")[address.split("\\.").length - 1];
            if (!end.contains("us") && !end.contains("uk") && !end.contains("com")) {
                System.out.printf("%s -> %s%n", input, address);
            }
            input = scanner.nextLine();
        }
    }
}
