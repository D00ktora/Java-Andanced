/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.3.2023 г.
 * Time: 8:48
 */
package P09FunctionalProgrammingLab;

import java.util.*;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .map(Integer::parseInt)
                .filter(r -> r % 2 == 0)
                .collect(Collectors.toList());
        List<String> rework = new ArrayList<>();

        for (Integer integer : integerList) {
            rework.add("" + integer);
        }
        System.out.println(String.join(", ", rework));

        List<Integer> secondList = new ArrayList<>();
        secondList.addAll(integerList);
        secondList = secondList.stream().sorted().collect(Collectors.toList());

        List<String> rework2 = new ArrayList<>();
        for (Integer integer : secondList) {
            rework2.add("" + integer);
        }

        System.out.println(String.join(", ", rework2));
    }
}
