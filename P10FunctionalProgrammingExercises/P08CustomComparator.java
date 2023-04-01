/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 17:46
 */
package P10FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> comparator = ((first, second) -> {
            //първо четно, второ нечетно -> не разменяме
            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            }
            //първо нечетно, второ четно -> размяна
            else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            }
            //първо четно, второто четно
            //първи нечетно, второто нечетно
            else {
                return first.compareTo(second);
                //first == second -> 0 -> няма размяна
                //first < second -> -1 -> няма размяна
                //first > second -> 1 -> има размяна
            }
        });

        numbers.sort(comparator);
        numbers.forEach(number -> System.out.printf("%d ",number));
    }
}
