/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 17:36
 */
package P10FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>, Integer> smallNumb = list -> {
            int minNumber = list.get(0);
            for (Integer integer : list) {
                if (integer < minNumber) {
                    minNumber = integer;
                }
            }
            return list.lastIndexOf(minNumber);
        };

        int min = smallNumb.apply(integerList);
        System.out.println(min);
    }
}
