/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 10:08
 */
package P09FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BiPredicate<String, Integer> types = (type, number) -> {
            if (type.equals("even")) {
                return number % 2 == 0;
            } else {
                return number % 2 != 0;
            }
        };

        int[] bounds = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String type = scanner.nextLine();

        IntStream.range(bounds[0], bounds[1] + 1)
                .filter(number -> types.test(type, number))
                .forEach(number -> {
                    System.out.print(number + " ");
                });
    }
}
