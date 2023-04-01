/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 9:49
 */
package P09FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int integer = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> person = new LinkedHashMap<>();

        for (int i = 0; i < integer; i++) {
            String input = scanner.nextLine();
            person.put(input.split(", ")[0], Integer.parseInt(input.split(", ")[1]));
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        switch (format) {
            case "name age":
                if (condition.contains("younger")) {
                    person.entrySet()
                            .stream()
                            .filter(r -> r.getValue() <= age)
                            .forEach(r -> System.out.println(r.getKey() + " - " + r.getValue()));
                } else if (condition.contains("older")) {
                    person.entrySet()
                            .stream()
                            .filter(r -> r.getValue() >= age)
                            .forEach(r -> System.out.println(r.getKey() + " - " + r.getValue()));
                }
                break;
            case "name":
                if (condition.contains("younger")) {
                    person.entrySet()
                            .stream()
                            .filter(r -> r.getValue() <= age)
                            .forEach(r -> System.out.println(r.getKey()));
                } else if (condition.contains("older")) {
                    person.entrySet()
                            .stream()
                            .filter(r -> r.getValue() >= age)
                            .forEach(r -> System.out.println(r.getKey()));
                }
                break;
            case "age":
                if (condition.contains("younger")) {
                person.entrySet()
                        .stream()
                        .filter(r -> r.getValue() <= age)
                        .forEach(r -> System.out.println(r.getValue()));
            } else if (condition.contains("older")) {
                person.entrySet()
                        .stream()
                        .filter(r -> r.getValue() >= age)
                        .forEach(r -> System.out.println(r.getValue()));
            }
                break;
        }
    }
}
