/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 17:56
 */
package P10FunctionalProgrammingExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        BiPredicate<List<Integer>, Integer> devisable = (list, num) -> {
            for (Integer integer : list) {
                if (num % integer != 0) {
                    return false;
                }
            }
            return true;
        };

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            if (devisable.test(numbersList, i)) {
                result.add(i);
            }
        }

        result.forEach(ele -> System.out.printf("%d ", ele));
    }
}
