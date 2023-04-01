/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 4.3.2023 г.
 * Time: 17:38
 */
package P06SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();
        String input = scanner.nextLine();

        while (!input.contains("search")) {
            String name = input.split("-")[0];
            String phone = input.split("-")[1];
            if (!phonebook.containsKey(name)) {
                phonebook.put(name, "");
            }
            phonebook.put(name,phone);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.contains("stop")) {
            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = scanner.nextLine();
        }
    }
}
