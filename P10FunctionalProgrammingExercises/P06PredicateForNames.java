/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 17:20
 */
package P10FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Predicate<String> checkLength = string -> string.length() <= number;

        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        words.removeIf(w -> !checkLength.test(w));
        words.forEach(System.out::println);
    }
}
